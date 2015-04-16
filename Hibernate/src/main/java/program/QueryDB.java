package program;

import hibernate.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import dao.Factory;
import entity.Buying;
import entity.Product;
import entity.User;

/**
 * Запросы для работы с БД
 */
public class QueryDB {
	/**
	 * Выводится список товаров из одной категории, отсортированный по цене
	 */
	public static void getListProducts(String category) throws SQLException {
		Session session = null;
		List<?> list = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            list = session.createCriteria(Product.class)
            		.add(Restrictions.like("category", category))
            		.addOrder(Order.asc("price"))
            		.list();
            session.getTransaction().commit();
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
		Iterator<?> it = list.iterator();
		Product pr = new Product();
		System.out.println("----------Список товаров категории \""+category+"\" отсортированный по цене (20 шт. на стр.)----------");
		int count = 0;
		while (it.hasNext()) {
			if (count == 20) break;
			pr = (Product)it.next();
			System.out.println(pr.toString());
			count++;
		}
	}


	/**
	 * Покупка товара пользователем (транзакция)
	 */
	public static void purchase(User user, Product product, int count) throws SQLException {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		if (((product.getCount()-count)<0)||((user.getMoney()-(product.getPrice()*count))<0)) {
			System.out.println("Ошибка, недостаточно товара или денег для покупки");
			throw new HibernateException("Недостаточно товара или денег для покупки");
		}
		try {
			session.beginTransaction(); /* Открываем транзакцию */
			user.setMoney(user.getMoney()-product.getPrice()*count);
			product.setCount(product.getCount()-count);
			Factory.getInstance().getUserDAO().update(user);
			Factory.getInstance().getProductDAO().update(product);
			Buying buy = new Buying();	//создаем покупку
			buy.setDate(new Date());
			buy.setCount(count);
			buy.setProduct(product);
			buy.setUser(user);
			session.save(buy);	//сохранияем покупку в БД
			session.getTransaction().commit(); /* Закрываем */
		}	
		catch (HibernateException e) {
			if (session.getTransaction().isActive()) {
				session.getTransaction().rollback();
				}
		} 
		finally {
			/* Не забываем закрыть сессию! */
			session.close();
		}
	}
	
	/**
	 * Выводим топ 10 наиболее продаваемых товаров
	 */
	public static void topSell() throws SQLException {
		Session session = null;
		List<?> listBuy = null;	//список всех покупок
		try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listBuy = session.createCriteria(Buying.class).list();	//запрашиваем список всех покупок
            session.getTransaction().commit();
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
		List<Buying> listTopSell = new ArrayList<Buying>();	//создадим список в котором отсортируем кол-во покупок
		Iterator<?> iter = listBuy.iterator();
		while (iter.hasNext()) {				//перебираем список всех покупок
			Buying buy = new Buying();
			buy = (Buying)iter.next();
			if (listTopSell.size()==0) {	 //если коллекция пуста заполняем первый элемент в новом списке
				listTopSell.add(buy);
				continue;
			}
			for (int i=0; i<listTopSell.size(); i++) {
				if (buy.getProduct().getId()==listTopSell.get(i).getProduct().getId()) {	//если продукт с таким ИД есть в коллекции, просто увеличиваем его кол-во
					listTopSell.get(i).setCount(listTopSell.get(i).getCount()+buy.getCount());
					break;
				}
				else if (i==listTopSell.size()-1) {	//если продукта с таким ИД нет, заносим в коллекцию
					listTopSell.add(buy);
					break;
				}
			}
		}
		Comparator<Buying> comparator = new Comparator<Buying>() {	//переопределяем компаратор
				public int compare(Buying obj1, Buying obj2) {
				return obj2.getCount() - obj1.getCount();
			}
		};
		Collections.sort(listTopSell, comparator);			//сортируем список покупок
		Iterator<Buying> iterator = listTopSell.iterator();		
		System.out.println("------------Топ 10 наиболее продаваемых товаров------------");
		int count = 0; //счетчик
		while (iterator.hasNext()) {	
			//перебираем список отбирая топ 10 наиболее продаваемых товаров
			if (count < 10) {
				Buying tempBuy = iterator.next();
				System.out.println("Категория: \""+tempBuy.getProduct().getCategory()+"\" Название: \""+
						tempBuy.getProduct().getProductName()+"\" Продано: \""+tempBuy.getCount()+"\" шт.");
				count++;
			} else break;
		}
	}
	
	/**
	 * Выводим список покупок пользователя
	 */
	public static void userBuying(User user) throws SQLException {
		Session session = null;
		List<?> listBuy = null;	//список покупок пользователя
		try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listBuy = session.createCriteria(Buying.class)			//заполняем список покупок пользователя
            		.add(Restrictions.eq("user", user))
            		.list();
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
		System.out.println("----------------Список покупок пользователя \""+user.getName()+"\"----------------");
		Iterator<?> iter = listBuy.iterator();
		while (iter.hasNext()) {
			Buying buy = (Buying)iter.next();
			System.out.println("Дата: \""+buy.getDate().toString()+"\" Название продукта: \"" +
			buy.getProduct().getProductName()+"\" Кол-во: \""+buy.getCount()+
			" шт.\" На сумму: \""+(buy.getCount()*buy.getProduct().getPrice())+" руб.\"");
		}
	}
}
