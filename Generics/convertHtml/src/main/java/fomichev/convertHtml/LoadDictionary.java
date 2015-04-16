package fomichev.convertHtml;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Класс загрузки словаря
 * @author Aleksey Fomichev
 */
public class LoadDictionary {
	File fin;						//Ссылка на файл
	List<String> dectionaryList;	//Коллекция хранящяя словарь
	Scanner sc;						//Сканнер для считывания текста из файла					
	
	/**
	 * Конструктор
	 */
	public LoadDictionary() {
		dectionaryList = new ArrayList<String>();
	}
	
	/**
	 * Считываем словарь в список и узнаем его длину
	 */
	int sizeDictionary(File file) {	
		dectionaryList.clear();
		try {
			fin = new File(file.getPath());
			sc = new Scanner(fin);
			while (sc.hasNextLine()) {
				dectionaryList.add(sc.nextLine());
			}
			sc.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("Файл словаря не найден");
			e.printStackTrace();
		} 
		finally {
			sc.close();
		}
		return dectionaryList.size();  
	}
}
