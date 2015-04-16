package fomichev.shoping;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * Класс магазин
 * @author Aleksey Fomichev
 */
public class Shop <T extends Goods> {
	
	List<T> foodsList = new LinkedList<T>();	//Список товаров
	
	/**
	 * Закупка товара
	 */
	public void buy(String name, double price) {
		Goods item = new Electronic(name, price);
		foodsList.add((T)item);
	}
	
	/**
	 * Закупка товара, путем добавления уже созданного объекта
	 */
	public void buy(T obj) {
		foodsList.add(obj);
	}
	
	/**
	 * Продажа товара
	 */
	public void sell(String name) {
		for (Iterator<T> iterator = foodsList.iterator(); iterator.hasNext();) {
			Goods item = (Goods)iterator.next();
			if (item.getName().equals(name)) {
				foodsList.remove(item);
				return;
			} 
		}
	};
	
	/**
	 * Устанавливает цену
	 */
	public void set(String name, double price) {
		for (Iterator<T> iterator = foodsList.iterator(); iterator.hasNext();) {
			Goods item = (Goods)iterator.next();
			if (item.getName().equals(name)) {
				item.setPrice(price);
				return;
			} 
		}
	}
	
	/**
	 * Получает объект заданного товара
	 */
	public Goods get(String name) {
		Goods item = null;
		for (Iterator<T> iterator = foodsList.iterator(); iterator.hasNext();) {
			item = (Goods)iterator.next();
			if (item.getName().equals(name)) {
				break;
			} 
		}
		return item;
	}
	
	/**
	 * Выводит информацию о товарах
	 */
	public void foodsPrint(){       //распечатать список товара
		System.out.println("Список товаров в магазине:"); 
		for (Iterator<T> iterator = foodsList.iterator(); iterator.hasNext();) {
			T item = (T)iterator.next();
			item.printInfo();
		}
	}
}
