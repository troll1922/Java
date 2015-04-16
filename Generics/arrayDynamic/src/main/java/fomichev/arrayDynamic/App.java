package fomichev.arrayDynamic;

/*
 * Динамический массив
 */
public class App {
    public static void main( String[] args ) {
        //Пример работы массива ArrayDynamic
    	ArrayDynamic<Integer> arr = new ArrayDynamic<Integer>();
    	arr.set(5, 50);	//заполняем произвольно массив
    	arr.set(1, 10);
    	arr.set(4, 40);
    	arr.print();	//распечатываем значения массива
    	System.out.println(arr.get(8));	//выводим значение null
    	arr.clear();	//очищаем массив
    	
    	//Сравнение затрат памяти 
    	Checking<Integer> check = new Checking<Integer>();
        check.TimeWorkingArrayDynamic(1, 100);		//заполняем массивы 100 значениями
        check.TimeWorkingLinkedList(1, 100);
        check.TimeWorkingArrayDynamic(1, 1000);		//заполняем массивы 1000 значениями
        check.TimeWorkingLinkedList(1, 1000);
        check.TimeWorkingArrayDynamic(1, 1000000);	//заполняем массивы 1000000 значениями
        check.TimeWorkingLinkedList(1, 1000000);
    }
}
