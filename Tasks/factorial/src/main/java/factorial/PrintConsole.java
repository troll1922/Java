package factorial;

import java.math.BigInteger;
import java.util.Scanner;

public class PrintConsole {
	
	private int value;
	
	public void start() {
		System.out.println("\"Программа - расчет факториала\"");
		System.out.println("Введите значение факториала:");
		Scanner sc= new Scanner(System.in);
        value = sc.nextInt();
        sc.close();
	}
	
	public int getValue() {
		return value;
	}
	
	public void outResult(BigInteger result) {
		if (result == BigInteger.valueOf(0)) System.out.println("Факториал должен быть >=0"); 
		else System.out.println("Факториал "+ value + " будет равен: " + result);
	}
}
