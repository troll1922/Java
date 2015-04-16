package fomichev.shoping;

/*
 * Класс мобильные телефоны
 * @author Aleksey Fomichev
 */
public class MobilePhone extends Electronic {
	
	private int sim;	//Количество сим-карт в телефоне
	
	/**
	 * Конструктор без параметров
	 */
	MobilePhone () {
		this("Mobile");
	}
	
	/**
	 * Конструктор с одним параметром
	 */
	MobilePhone (String name) {
		this(name, 0, 1);
	}
	
	/**
	 * Конструктор с двумя параметрами
	 */
	MobilePhone (String name, double price) {
		this(name, price, 1);
	}
	
	/**
	 * Конструктор с тремя параметрами
	 */
	MobilePhone (String name, double price, int sim) {
		super(name, price);
		this.sim = sim;
	}
	
	/**
	 * Получает количество сим-карт
	 */
	public int getSim() {
		return sim;
	}
	
	/**
	 * Устанавливает количество сим-карт
	 */
	public void setSim(int sim) {
		this.sim = sim;
	}
	
	/**
	 * Выводит информацию о сотовых телефонах
	 */
	@Override
	public void printInfo() {
		System.out.println("Сотовый телефон - " + this.getName() + " " + this.getPrice() +
				" руб. " + this.getSim() + " sim"); 
	}
}
