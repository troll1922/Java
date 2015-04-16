package jdbc;

import java.sql.SQLException;
import java.util.Random;

import entity.Product;
import entity.User;

/**
 *	Генератор для имитации работы с БД
 */
public class Generate {
	
	/**
	 *	Добавляем в БД пользователей
	 */
	public static void addUsers(int countUsers) throws SQLException {
		System.out.println("Генерируем добавление в БД пользователей");
		User userItem = null; 
		String userName = "userName";           //Имя пользователя
		double money = 200000;       		    //Счет
		String email = "@mail.ru";              //E-mail
		for (int i = 1; i<=countUsers; i++) {
			if ((i%5)==0) {
				money = 150000;
			} else if ((i%3)==0) {
				money = 180000;
			} else if ((i%2)==0) {
				money = 170000;
			}
			userItem = new User(userName+"_"+i, money, userName+i+email);	//конкатенацию строк желательно в дальнейшем через StringBuilder переделать
			userItem.create(new Property().getDBConnection());
		}
	}
	
	/**
	 *	Добавляем в БД продукты
	 */
	public static void addProducts(int countProducts) throws SQLException {
		System.out.println("Генерируем добавление в БД продукты");
		Product prodItem = null; 
		String productName = "productName";     //Название продукта
		double price;       			        //Cтоимость продукта
		int count;       		 		        //Количество продукта
		String category = "category";     	    //Категория продукта
		String description = "description";     //Описание продукта
		Random rand = new Random();
		for (int i = 1; i<=countProducts; i++) {
			if ((i%5)==0) {
				price = rand.nextInt(200);
				count = 850;
				category = "category_2";
			} else if ((i%3)==0) {
				price = rand.nextInt(200);
				count = 950;
				category = "category_3";
			} else if ((i%2)==0) {
				price = rand.nextInt(200);
				count = 750;
				category = "category_1";
			} else {
				price = rand.nextInt(200);
				count = 600;
				category = "category_1";
			}
			prodItem = new Product(productName+"_"+i, price, count, category, description+" "+productName+"_"+i);	//конкатенацию строк желательно в дальнейшем через StringBuilder переделать
			prodItem.create(new Property().getDBConnection());
		}
	}
	
	/**
	 *	Генерируем покупки в БД
	 */
	public static void addBuyings(int countBuyings) throws SQLException {
		System.out.println("Генерируем добавление в БД покупки");
		Product prodItem = new Product();
		User userItem = new User(); 
		for (int i = 1; i<=countBuyings; i++) {
			Random rand = new Random();
			userItem.read(rand.nextInt(100), new Property().getDBConnection());
			prodItem.read(rand.nextInt(200), new Property().getDBConnection());
			QueryDB.purchase(userItem, prodItem, rand.nextInt(10), new Property().getDBConnection());
		}
		
	}
}
