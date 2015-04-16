package fomichev.arrayDynamic;

/*
 * Это интерфейс предназначен для создания динамического массива
 * @author Aleksey Fomichev
 */
public interface Dynamic<E> {

	/**
	 * Получаем значение по индексу
	 */
	E get(int index);
	
	/**
	 * Очищаем массив
	 */
	void clear();
	
	/**
	 * Распечатываем значения массива
	 */
	void print();

}
