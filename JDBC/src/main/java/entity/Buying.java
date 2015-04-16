package entity;

import java.util.Date;

/**
 * Сущность покупка
 */
public class Buying {

    private int id;
    private Date date;		//дата покупки
    private int count;		//кол-во товара на складе
    private int userID;	    //покупатель
    private int productID;	//товар 
	
	public Buying() {
	}

	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}	
}
