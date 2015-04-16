package validation;

import java.util.Scanner;

public class PrintConsole {
	
	private String str;
	
	public void start() {
		System.out.println("\"Программа - валидация скобок\"");
		System.out.println("Введите строку скобок:");
		Scanner sc= new Scanner(System.in);
        str = sc.next();
        sc.close();
	}
	
	public String getString() {	
		return str;
	}
	
	public void outResult(boolean bool) {
		if (bool) System.out.println("Результат: введенная строка скобок валидная");
		else System.out.println("Результат: Error!!! Введенная строка скобок невалидная");
	}
}
