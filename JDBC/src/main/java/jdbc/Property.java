package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Настройка соединения с БД
 */
public class Property {
	private String URL = "jdbc:postgresql://localhost:5432/shop";
	private String user = "postgres";	//логин к БД
	private String pass = "admin";		//пароль к БД
	
	/**
	 * В конструкторе вызываем метод в котором загружаем драйвер по работе с БД
	 */
	Property () {
		loadDriver();
	}
	
	/**
	 * Загружаем драйвер БД
	 */
	public void loadDriver() {
		try {
	        Class.forName("org.postgresql.Driver"); //загружаем в память JVM драйвер базы данных
	    } 
	    catch (ClassNotFoundException e) {
	        e.getMessage();
	        System.out.println("Could not find the JDBC driver!");
	    }
	}
	
	/**
	 * Cоздание соединения с БД
	 */
	public Connection getDBConnection() {	//желательно в дальнейшем организовать pool
		Connection dbConnection = null;
	    try {
	        dbConnection = DriverManager.getConnection(URL, user, pass);
	        return dbConnection;
	    } catch (SQLException e) {
	    	e.getMessage();
	    }
	    System.out.println("Подключиться к БД не удалось");
	    return dbConnection;		//по идеи надо отлавливать эту ошибку, в том месте где вызывается этот метод
	}		
}
