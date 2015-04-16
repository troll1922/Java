package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Создание таблиц в БД
 */
public class CreateTables {
	
	/**
	 * Создание таблицы пользователей
	 */
	public static void buildUsers(Connection dbConnection) {
		DatabaseMetaData meta;
		//проверяем, есть ли такая таблица в БД
		try {
			meta = dbConnection.getMetaData();
			ResultSet res = meta.getTables(null, null, "users", null);
			if (res.next()) {
				System.out.println("Таблица USERS в базе данных SHOP уже создана");
			} 
			else {
				res.close();
				Statement st = null;
				st = dbConnection.createStatement();
				String createTableUsers = "CREATE TABLE users" +
	                      "(id SERIAL PRIMARY KEY     NOT NULL," +
	                      " user_name      TEXT       NOT NULL," +
	                      " money   DOUBLE PRECISION  NOT NULL," +
	                      " email          TEXT       NOT NULL)";
				st.executeUpdate(createTableUsers);
				System.out.println("Таблица USERS в БД SHOP создана");
			}
		}
		catch (SQLException e) {
			e.getMessage();
		}
		finally {
			try {
				dbConnection.close();
			} 
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	/**
	 * Создание таблицы с продуктами
	 */
	public static void buildProducts(Connection dbConnection) {
		DatabaseMetaData meta;
		//проверяем, есть ли такая таблица в БД
		try {
			meta = dbConnection.getMetaData();
			ResultSet res = meta.getTables(null, null, "products", null);
			if (res.next()) {
				System.out.println("Таблица PRODUCTS в базе данных SHOP уже создана");
			} 
			else {
				res.close();
				Statement st = null;
				st = dbConnection.createStatement();
				String createTableProducts = "CREATE TABLE products" +
	                      "(id SERIAL PRIMARY KEY    NOT NULL," +
	                      " product_name   TEXT      NOT NULL," +
	                      " price   DOUBLE PRECISION NOT NULL," +
	                      " count          INTEGER   NOT NULL," + 
	                      " category       TEXT      NOT NULL," + 
	                      " description    TEXT      NOT NULL)";
				st.executeUpdate(createTableProducts);
				System.out.println("Таблица PRODUCTS в БД SHOP создана");
			}
		}
		catch (SQLException e) {
			e.getMessage();
		}
		finally {
			try {
				dbConnection.close();
			} 
			catch (SQLException e) {
				e.getMessage();
			}
		}
	}
	
	/**
	 * Создание таблицы покупок
	 */
	public static void buildBuyings(Connection dbConnection) {
		DatabaseMetaData meta;
		//проверяем, есть ли такая таблица в БД
		try {
			meta = dbConnection.getMetaData();
			ResultSet res = meta.getTables(null, null, "buyings", null);
			if (res.next()) {
				System.out.println("Таблица BUYINGS в базе данных SHOP уже создана");
			} 
			else {
				res.close();
				Statement st = null;
				st = dbConnection.createStatement();
				String createTableBuyings = "CREATE TABLE buyings" +
	                      "(id SERIAL PRIMARY KEY    NOT NULL," +
	                      " date           DATE      NOT NULL," +
	                      " count          INTEGER   NOT NULL," +
	                      " product_id     INTEGER   REFERENCES products (id)," +
	                      " user_id        INTEGER   REFERENCES users (id))";
				st.executeUpdate(createTableBuyings);
				System.out.println("Таблица BUYINGS в БД SHOP создана");
			}
		}
		catch (SQLException e) {
			e.getMessage();
		}
		finally {
			try {
				dbConnection.close();
			} 
			catch (SQLException e) {
				e.getMessage();
			}
		}
	}
}
