package entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import DAO.Idao;

/**
 * Cущность "Продукт"
 */
public class Product implements Idao<Product> {
    private int id;
    private String productName;      //Название продукта
	private double price;       	 //Cтоимость продукта
	private int count;       		 //Количество продукта
    private String category;         //Категория продукта
    private String description;      //Описание продукта
	
	public Product() {
	}
	
	public Product(String productName, double price, int count, String category, String description) {
		this.productName = productName;
		this.price = price;
		this.count = count;
		this.category = category;
		this.description = description;
	}
	
	//Getters and Setters
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * Создание сущности "Продукт"
	 */
	public void create(Connection dbConnection) throws SQLException {
		Statement st = null;
		st = dbConnection.createStatement();
		String createProduct = "INSERT INTO products (product_name, price, count, category, description) VALUES" +
				"('"+this.getProductName()+"',"+this.getPrice()+","+this.getCount()+",'"+this.getCategory()+"','"+this.getDescription()+"')";
		st.executeUpdate(createProduct);
		ResultSet rs = st.executeQuery("SELECT id FROM products ORDER BY id DESC limit 1;");
		if (rs.next()) {
			this.setId(rs.getInt(1));	//в созданный оъект записываем ID (сгенерированный в БД)
		}
		st.close();
		dbConnection.close();
	}
	
	/**
	 * Считывание сущности "Продукт" из БД по ID
	 */
	public void read(int id, Connection dbConnection) throws SQLException {
		Statement st = null;
		st = dbConnection.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM products WHERE id = " + id + ";");
		if (rs.next()) {
			this.setId(rs.getInt(1));
			this.setProductName(rs.getString(2));
			this.setPrice(rs.getDouble(3));
			this.setCount(rs.getInt(4));
			this.setCategory(rs.getString(5));
			this.setDescription(rs.getString(6));
		}
		st.close();
		dbConnection.close();
	}
	
	/**
	 * Обновление сущности "Продукт" в БД
	 */
	public void update(Connection dbConnection) throws SQLException {
		Statement st = null;
		st = dbConnection.createStatement();
		String updateProduct = "UPDATE products SET (product_name, price, count, category, description)= " +
				"('"+this.getProductName()+"',"+this.getPrice()+","+this.getCount()+",'"+this.getCategory() + 
				"','"+this.getDescription()+"') WHERE id ="+this.getId()+";";
		st.executeUpdate(updateProduct);
		st.close();
		dbConnection.close();
	}
	
	/**
	 * Удаление сущности "Продукт" из БД
	 */
	public void delete(Connection dbConnection) throws SQLException {
		Statement st = null;
		st = dbConnection.createStatement();
		st.execute("DELETE FROM products WHERE ID = " + this.getId()+ ";");
		st.close();
		dbConnection.close();
	}
	
	@Override
    public String toString() {
		String str;
		str = "Id_\""+this.getId()+"\" название_\""+this.getProductName()+"\" цена_\""+this.getPrice()+
		 "\" количество_\""+this.getCount()+"\" описание_\""+this.getDescription()+"\"";
		return str;
	}
}
