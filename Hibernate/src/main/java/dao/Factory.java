package dao;

/**
 *	Класс Factory в котором обращаемся к нашим реализация DAO (паттерн Фабрика)
 */
public class Factory {
	     
	      private static UserDAOImpl userDAO = null;
	      private static ProductDAOImpl productDAO = null;
	      private static Factory instance = null;

	      public static synchronized Factory getInstance(){
	            if (instance == null){
	              instance = new Factory();
	            }
	            return instance;
	      }
	      
	      public UserDAOImpl getUserDAO(){
	            if (userDAO == null){
	              userDAO = new UserDAOImpl();
	            }
	            return userDAO;
	      }  
	      
	      public ProductDAOImpl getProductDAO(){
	            if (productDAO == null){
	            	productDAO = new ProductDAOImpl();
	            }
	            return productDAO;
	      }  
}
