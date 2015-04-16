package fomichev.shoping;

/*
 * Интерфейс товары
 * @author Aleksey Fomichev
 */
public interface Goods {
	
	/**
	 * Задает имя товару
	 */
	public void setName(String name);  
	
	/**
	 * Утсанавливает цену товару
	 */
	public void setPrice(double price);
	
	/**
	 * Получает название товара
	 */
	public String getName();
	
	/**
	 * Получает цену товара
	 */
	public double getPrice();
	
	/**
	 * Выводит информацию по товарам
	 */
	public void printInfo();	
}
