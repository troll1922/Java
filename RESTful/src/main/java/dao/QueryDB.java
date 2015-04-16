package dao;

import hibernate.HibernateUtil;
import java.sql.SQLException;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import dao.Factory;
import entity.Buying;
import entity.Product;
import entity.User;

/**
 * Запросы для работы с БД
 */
public class QueryDB {
	/**
	 * Покупка товара пользователем (транзакция)
	 */
	public static void purchase(User user, Product product) throws SQLException {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		if (((user.getMoney()-(product.getPrice()))<0)) {
			System.out.println("Ошибка, недостаточно товара или денег для покупки");
			throw new HibernateException("Недостаточно товара или денег для покупки");
		}
		try {
			session.beginTransaction(); /* Открываем транзакцию */
			user.setMoney(user.getMoney()-product.getPrice());
			Factory.getInstance().getUserDAO().update(user);
			Buying buy = new Buying();	//создаем покупку
			buy.setDate(new Date());
			buy.setProduct(product.getId());
			buy.setUser(user.getId());
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
}
