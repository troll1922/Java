package fomichev.arrayDynamic;

import java.util.LinkedList;
import java.util.List;

/*
 * Это класс предназначен для проверки затраты времени разработанного динамического массива и стандартных коллекций
 * @author Aleksey Fomichev
 */
public class Checking<T> {
	/**
	 * Расчет затрат времени у разработанного динамического массива
	 */
	public void TimeWorkingArrayDynamic(T value, int count) {
		ArrayDynamic<T> arr = new ArrayDynamic<T>();
		long start = System.currentTimeMillis(); 
        for (int i = 0; i<count; i++) {
        	arr.set(i, value);
        }
        long end = System.currentTimeMillis(); 
        //arr.print();	//распечатка значений массива 
        System.out.println("Time ArrayDynamic: " + (end - start) + "ms" + " (" + count + ")");
	}
	
	/**
	 * Расчет затрат времени у коллекции LinkedList
	 */
	public void TimeWorkingLinkedList(T value, int count) {
		List<T> list = new LinkedList<T>();
		long start = System.currentTimeMillis(); 
        for (int i = 0; i<count; i++) {
        	list.add(value);
        }
        long end = System.currentTimeMillis(); 
        System.out.println("Time LinkedList: " + (end - start) + "ms" + " (" + count + ")");
	}
}
