package fomichev.shoping;

/*
 * Класс электроника
 * @author Aleksey Fomichev
 */
public class Electronic implements Goods {

	private String name;	//Название товара
	private double price;	//Цена товара
	
	/**
	 * Конструктор с двумя параметрами
	 */
	public Electronic(String name, double price){
		this.name = name;
		this.price = price;
	}
	
	/**
	 * Конструктор с одним параметром
	 */
	public Electronic(String name){
		this(name, 0);	
	}
	
	/**
	 * Конструктор по умолчанию
	 */
	public Electronic(){
		this("Электроника");
	}
	
	/**
	 * Получает название товара
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Устанавливает имя товара
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Получает цену товара
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Устанавливает цену товара
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Выводит название и цену товара
	 */
	public void printInfo() {
		System.out.println("Электроника - " + this.getName() + " " + this.getPrice() + " руб."); 
	}
}
