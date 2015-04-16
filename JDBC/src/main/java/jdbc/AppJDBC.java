package jdbc;

import java.sql.SQLException;

import entity.User;

/**
 * JDBC
 */
public class AppJDBC {
	
    public static void main(String[] args) {
    	System.out.println("Работа с JDBC (БД PostgreSQL)");
    	//настраиваем параметры для работы с БД
    	Property set = new Property();
    	//создаем таблицы в БД
    	CreateTables.buildUsers(set.getDBConnection());	
    	CreateTables.buildProducts(set.getDBConnection());
    	CreateTables.buildBuyings(set.getDBConnection());
    	//имитируем работу с БД
    	try {
    		Generate.addProducts(200);	//генерируем продукты в БД
    		Generate.addUsers(100);		//генерируем пользователей в БД
    		Generate.addBuyings(250);	//генерируем покупки в БД
        	System.out.println("Имитируем запросы к БД\n");
    		//список товаров из одной категории, отсортированный по цене
    		QueryDB.getListProducts("category_1", set.getDBConnection());
    		User user = new User();
    		user.read(10, set.getDBConnection());	//считываем из БД пользователя, чтоб по нему вывести список его покупок
    		System.out.println("");
    		//список покупок пользователя
    		QueryDB.userBuying(user, set.getDBConnection());
    		System.out.println("");
    		//топ 10 наиболее продаваемых товаров
    		QueryDB.topSell(set.getDBConnection());
    	}
    	catch (SQLException e) {
			e.getMessage();
		}
    }
}
