package entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.Idao;

/**
 * Cущность "User"
 */
public class User implements Idao<User> {
    private int id;
    private String name;
    private Double money;
    private String email;
    
	public User() {
	}
	
	public User(String name, Double money, String email) {
		this.name = name;
		this.money = money;
		this.email = email;
	}

	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Создание сущности "User"
	 */
	public void create(Connection dbConnection) throws SQLException {
		Statement st = null;
		st = dbConnection.createStatement();
		String createUser = "INSERT INTO users (user_name, money, email) VALUES" +
				"('"+this.getName()+"',"+this.getMoney()+",'"+this.getEmail()+"')";
		st.executeUpdate(createUser);
		ResultSet rs = st.executeQuery("SELECT id FROM users ORDER BY id DESC limit 1;");
		if (rs.next()) {
			this.setId(rs.getInt(1));	//в созданный оъект записываем ID (сгенерированный БД)
		}
		st.close();
		dbConnection.close();
	}

	/**
	 * Считывание сущности "User" из БД по ID
	 */
	public void read(int id, Connection dbConnection) throws SQLException {
		Statement st = null;
		st = dbConnection.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM users WHERE id = " + id + ";");
		if (rs.next()) {
			this.setId(rs.getInt(1));
			this.setName(rs.getString(2));
			this.setMoney(rs.getDouble(3));
			this.setEmail(rs.getString(4));
		}
		st.close();
		dbConnection.close();
	}

	/**
	 * Обновление сущности "User" в БД
	 */
	public void update(Connection dbConnection) throws SQLException {
		Statement st = null;
		st = dbConnection.createStatement();
		String updateUser = "UPDATE users SET (user_name, money, email)= " +
				"('"+this.getName()+"',"+this.getMoney()+",'"+this.getEmail()+"') WHERE id ="+this.getId()+";";
		st.executeUpdate(updateUser);
		st.close();
		dbConnection.close();
	}

	/**
	 * Удаление сущности "User" из БД
	 */
	public void delete(Connection dbConnection) throws SQLException {
		Statement st = null;
		st = dbConnection.createStatement();
		st.execute("DELETE FROM users WHERE ID = " + this.getId()+ ";");
		st.close();
		dbConnection.close();
	}
}
