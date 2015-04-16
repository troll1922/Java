package searchArray;

import java.util.Scanner;

public class PrintConsole {
	
	private int size;
	
	public void start() {
		System.out.println("\"Программа - поиск 2-х пропущенных чисел в массиве\"");
		System.out.println("Задайте размер массива:");
		Scanner sc= new Scanner(System.in);
        size = sc.nextInt();
        sc.close();
	}
	
	public int getSize() {	
		return size;
	}
	
	public void outResult(int one, int two) {
		System.out.println("В массиве пропущены следующие 2 числа:");
		System.out.println(one + " " + two);
	}
}
