package searchArray;

import java.util.Random;

public class SearchArray {
	//пропущенные числа в массиве
	private int one, two;
	private int array[];
	
	public SearchArray() {
		one = two = -1;
	}
	
	//генерируем массив
	public void generateArray(int size) {
		array = new int [size];
		//генерируем два числа которые будут пропущены в массиве
		Random rand = new Random();
		int one = rand.nextInt(size+1);
		int two = rand.nextInt(size+1);
		if ((one==two) && (one!=0)) two = one-1;
		//заполняем массив 
		System.out.println("Полученный массив:");
		int value = 0;
		for (int i = 0; i<array.length; i++) {
			if ((i == one)||(i == two)) value++;
			array[i] = i+value;
			System.out.print(array[i] + " ");
			if ((i>0)&&((i % 10) == 0)) System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	//поиск пропущенных чисел в массиве
	public void scan() {
		int preview = 0, current;
		for (int i = 0; i<array.length; i++) {
			if (i == 0) {
				preview = array[i];
				if (preview == 1) one = 0;
				else if (preview == 2) { one = 0; two = 1; break; }
				continue;
			}
			current = array[i];
			if (preview == (current-1)) { preview = current; continue; }
			if (preview == (current-2)) {
				if (one == -1) one = preview + 1;	//находим первое число
				else two = preview + 1;	//находим второе число
				preview = current;
			}
			if (preview == (current-3)) {
				one = preview + 1;
				two = preview + 2;
				break;
			}
		}
	}
	
	//устанавливаем массив чисел в ручную
	public void setArray(int[] arr) {
		array = arr;
	}
	
	public int getOne() {
		return one;
	}
	
	public int getTwo() {
		return two;
	}
}
