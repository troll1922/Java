package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
	public static void getListProducts(String category, Connection dbConnection) throws SQLException {
		Product pr;
		List<Product> list = new ArrayList<Product>();
		Statement st = null;
		st = dbConnection.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM products WHERE category = '"+category+"' ORDER BY price ASC;");
		dbConnection.close();
		while (rs.next()) {
			pr = new Product();
			pr.setId(rs.getInt(1));
			pr.setProductName(rs.getString(2));
			pr.setPrice(rs.getDouble(3));
			pr.setCount(rs.getInt(4));
			pr.setCategory(rs.getString(5));
			pr.setDescription(rs.getString(6));
			list.add(pr);
		}
		Iterator<Product> it = list.iterator();
		pr = new Product();
		System.out.println("----------Список товаров категории \""+category+"\" отсортированный по цене (20 шт. на стр.)----------");
		int count = 0;
		while (it.hasNext()) {
			if (count == 20) break;
			pr = it.next();
			System.out.println(pr.toString());
			count++;
		}
	}
	
	/**
	 * Покупка товара пользователем (транзакция)
	 */
	public static void purchase(User user, Product product, int count, Connection dbConnection) throws SQLException {
		try {
			if (((product.getCount()-count)<0)||((user.getMoney()-(product.getPrice()*count))<0)) {
				System.out.println("Ошибка, недостаточно товара или денег для покупки");	//желательно распарсить ошибку, чтоб пользователю было видно из-за чего ошибка
				throw new SQLException();
			}
			dbConnection.setAutoCommit(false);
			Date date = new Date();
			Statement st = null;
			st = dbConnection.createStatement();
			String updateUser = "UPDATE users SET money = " + (user.getMoney()-(product.getPrice()*count)) +
					" WHERE id =" + product.getId() + ";";
			st.executeUpdate(updateUser);
			String updateProduct = "UPDATE products SET count = " + (product.getCount()-count) +
					" WHERE id =" + product.getId() + ";";
			st.executeUpdate(updateProduct);
			String createBuying = "INSERT INTO buyings (date, count, product_id, user_id) VALUES" +
					"('"+date.toString()+"',"+count+","+product.getId()+","+user.getId()+")";
			st.executeUpdate(createBuying);
			st.close();
			dbConnection.commit();
			dbConnection.close();
		}
		catch (SQLException e) {
			dbConnection.rollback();
		}
	}
	
	/**
	 * Выводим топ 10 наиболее продаваемых товаров
	 */
	public static void topSell(Connection dbConnection) throws SQLException {
		Buying buy;
		List<Buying> listBuy = new ArrayList<Buying>();
		Statement st = null;
		st = dbConnection.createStatement();
		ResultSet rs = st.executeQuery("SELECT count, product_id FROM buyings;");
		while (rs.next()) {				//перебираем ResultSet
			buy = new Buying();
			buy.setCount(rs.getInt(1));          
			buy.setProductID(rs.getInt(2));
			if (listBuy.size()==0) {	 //если коллекция пуста заполняем первый элемент в коллекции
				listBuy.add(buy);	
				continue;
			}
			for (int i=0; i<listBuy.size(); i++) {
				if (buy.getProductID()==listBuy.get(i).getProductID()) {	//если продукт с таким ИД есть в коллекции, просто увеличиваем его кол-во
					listBuy.get(i).setCount(listBuy.get(i).getCount()+buy.getCount());
					break;
				}
				else if (i==listBuy.size()-1) {	//если продукта с таким ИД нет, заносим в коллекцию
					listBuy.add(buy);
					break;
				}
			}
		}
		Comparator<Buying> comparator = new Comparator<Buying>() {	//переопределяем компаратор
				public int compare(Buying obj1, Buying obj2) {
				return obj2.getCount() - obj1.getCount();
			}
		};
		Collections.sort(listBuy, comparator);			//сортируем список покупок
		Iterator<Buying> iter = listBuy.iterator();		
		Product tempProd = new Product();				//временный объект для хранения данных о продукте
		System.out.println("------------Топ 10 наиболее продаваемых товаров------------");
		int count = 0; //счетчик
		while (iter.hasNext()) {	
			//перебираем список отбирая топ 10 наиболее продаваемых товаров
			if (count < 10) {
				Buying tempBuy = iter.next();
				tempProd.read(tempBuy.getProductID(), new Property().getDBConnection());
				System.out.println("Категория: \""+tempProd.getCategory()+"\" Название: \""+
						tempProd.getProductName()+"\" Продано: \""+iter.next().getCount()+"\" шт.");
				count++;
			} else break;
		}
		st.close();
		dbConnection.close();
	}
	
	/**
	 * Выводим список покупок пользователя
	 */
	public static void userBuying(User user, Connection dbConnection) throws SQLException {
		Buying buy;
		Product product;
		List<Buying> listBuy = new ArrayList<Buying>();	//список покупок пользователя
		Map<Buying, Product> mapBuyProduct = new HashMap<Buying, Product>();//список покупок и продуктов, кот. покупал пользователь
		Statement st = null;
		st = dbConnection.createStatement();
		//делаем запрос на выборку покупок по ИД пользователя
		ResultSet rs = st.executeQuery("SELECT date, count, product_id FROM buyings WHERE user_id = "+user.getId()+";");
		while (rs.next()) {
			buy = new Buying();
			buy.setDate(rs.getDate(1));	
			buy.setCount(rs.getInt(2));
			buy.setProductID(rs.getInt(3));
			listBuy.add(buy);				//заполняем список покупок пользователя
		}
		Iterator<Buying> iter = listBuy.iterator();
		while (iter.hasNext()) {
			//считываем информацию по продуктам, кот. покупал пользователь
			buy = iter.next();
			product = new Product();
			product.read(buy.getProductID(), new Property().getDBConnection());
			mapBuyProduct.put(buy, product);
		}
		System.out.println("----------------Список покупок пользователя \""+user.getName()+"\"----------------");
		for (Map.Entry<Buying, Product> entry : mapBuyProduct.entrySet()) {	
			System.out.println("Дата: \""+entry.getKey().getDate().toString()+"\" Название продукта: \"" +
					entry.getValue().getProductName()+"\" Кол-во: \""+entry.getKey().getCount()+
					" шт.\" На сумму: \""+(entry.getKey().getCount()*entry.getValue().getPrice())+" руб.\"");
		} 
		st.close();
		dbConnection.close();
	}
}
