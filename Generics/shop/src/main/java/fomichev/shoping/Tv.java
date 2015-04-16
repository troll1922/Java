package fomichev.shoping;

/*
 * Класс тв
 * @author Aleksey Fomichev
 */
public class Tv extends Electronic{
	
	private boolean threeD;	//
	
	/**
	 * Конструктор без параметров
	 */
	Tv () {
		this("Tv");	
	}
	
	/**
	 * Конструктор с одним параметром
	 */
	Tv (String name) {
		this(name, 0);
	}
	
	/**
	 * Конструктор с двумя параметрами
	 */
	Tv (String name, double price) {
		this(name, price, false);
	}
	
	/**
	 * Конструктор с тремя параметрами
	 */
	Tv (String name, double price, boolean bool) {
		super(name, price);
		this.threeD = bool;
	}
	
	/**
	 * Наличие функции 3D
	 */
	public boolean isThreeD() {
		return threeD;
	}
	
	/**
	 * Задает функцию 3D
	 */
	public void setThreeD(boolean threeD) {
		this.threeD = threeD;
	}
	
	/**
	 * Выводит информацию о тв
	 */
	@Override
	public void printInfo() {
		String str3D;
		if (this.isThreeD()) {
			str3D = "3D поддерживатеся";
		}
		else {
			str3D = "3D не поддерживатеся";
		}
		
		System.out.println("Телевизор - " + this.getName() + " " + this.getPrice() + " руб. " + str3D); 
	} 
}
