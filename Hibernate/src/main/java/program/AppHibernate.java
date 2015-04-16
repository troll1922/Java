package program;

import java.sql.SQLException;
import java.util.Random;

import dao.Factory;

/**
 * Работа c Hibernate
 */
public class AppHibernate {
	
    public static void main(String[] args) {
    	System.out.println("Начало работы программы 'AppHibernate'");
    	try {
			Generate.addUsers(50); //генерируем юзеров
			Generate.addProducts(200);	//генерируем продукты
    		QueryDB.getListProducts("category_"+(new Random().nextInt(3)+1)); //список товаров n-й категории
    		Generate.addBuyings(300);	//Генерируем покупки
    		QueryDB.topSell();	//топ 10 лучших покупок
    		QueryDB.userBuying(Factory.getInstance().getUserDAO().get(new Random().nextInt(49)+1));	//покупки пользователя
    		
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
    }
}
