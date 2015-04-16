package fomichev.arrayDynamic;

/*
 * Это класс предназначен для создания динамического массива, унаследованный от интерфейса Dynamic
 * @author Aleksey Fomichev
 */
public class ArrayDynamic<T> implements Dynamic {
	
	private int size = 0;	//размер массива
	public Links<T> first;	//первый элемент в массиве
	public Links<T> last;	//последний элемент в массиве
	
	/**
	 * Иннер класс, хранящий заданные значения, индекс, ссылки на предыдущий и следующий элемент
	 */
	private class Links<T> {
		private int index;
		private T value;
		public Links<T> next;
		public Links<T> prev;
		public Links(int index, T value) {
			this.index = index;
			this.value = value;
		}
	}
	
	/**
	 * Устанавливаем значение по индексу в массиве
	 */
	public void set(int index, T value) {
		Links<T> item = new Links<T>(index, value);	//создаем объект иннер класса
		if (size == 0) {	
		//вставляем первый элемент в пустой массив
			first = last = item;
			size++;
			return;
		}
		else if (size == 1) {
		//вставляем второй элемент в массив
			if (index > first.index) {
				last = item;
				last.prev = first;
				first.next = last;
				size++;
				return;                       
			}
			else if (index < first.index) {  
				first = item;
				last.prev = first;
				first.next = last;
				size++;
				return;
			}
			else if (index == first.index) {
				first = last = item;
				return;
			}
		}
		else if (size > 1) {
		//вставляем следующие элементы в массив
			Links<T> temp = first;
			if (index<first.index) {
			//если заданный индекс меньше первого в массиве
				item.next = first;
				first.prev = item;
				first = item;
				size++;
				return;
			}
			else if (index>last.index) {
			//если заданный индекс больше последнего в массиве
				item.prev = last;
				last.next = item;
				last = item;
				size++;
				return;
			}
			else {
			//если заданный индекс между первым и последним в массиве
				for (int i=0;i<size;i++) {
					//перебираем весь массив
					if (temp.index <= index) {
						if (temp.index == index) {
						//если заданный индекс уже имеется
							temp.value = value;	//перезаписываем значение
							return;
						} else {
							temp = temp.next;	//копируем во временный объект, следующий за заданным индексом 
							continue;
						}
					}
					//перераспределяем ссылки между объектами
					item.next = temp;
					item.prev = temp.prev;
					item.prev.next = item;
					temp.prev = item;
					size++;
					return;
				}
			}
		}	
	}
	
	/**
	 * Получаем значение по индексу
	 */
	public T get(int index) {
		T value = null;
		Links<T> temp = first; 
		for (int i=0;i<size;i++) {
			if (temp.index == index) {
				value = temp.value;
			}
			temp = temp.next;
		}
		return value;
	}
	
	/**
	 * Очищаем масив
	 */
	public void clear() {
		first = null;
		last = null;
		size = 0;
	}
	
	/**
	 * Распечатываем значения массива
	 */
	public void print() {
		Links<T> temp = first;
		int count = size;
		while ((count--)!=0) {
			System.out.println(temp.index + " " + temp.value);
			temp = temp.next;
		}
	}
}
