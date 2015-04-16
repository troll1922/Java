package validation;

import java.util.ArrayList;
import java.util.List;

public class Validation {

	public Validation() {
		super();
	}
	
	public boolean getSolve(String str) {
		String sc = "()";
		int open = sc.codePointAt(0); //узнаем код скобок
		int close = sc.codePointAt(1);
		//переберем всю строку, отбирая скобки в список
		List<Integer> list = new ArrayList<Integer>();
		int openCount = 0, closeCount = 0;
		for (int i=0; i<str.length(); i++) {
			if (str.codePointAt(i) == open) {
				list.add(open);
				openCount++;
			}
			else if (str.codePointAt(i) == close) {
				list.add(close);
				closeCount++;
			} 
		}
		if (openCount == closeCount) { //если открывающих и закрывающих скобок одинаково, то разбираем строку дальше
			int size = list.size(); //количество скобок
			if (list.get(0) == close) return false;	//первая закрывающая скобка
			else if (list.get(size-1) == open) return false;	//последняя открывающая скобка
			int check = 0;
			for (int i=0; i<size; i++) {
				if (open==list.get(i)) check--;
				else check++;
				if (check>0) return false;
			}
			return true;
		}	
		else return false;
	}
}
