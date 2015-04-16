package appPlugins;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Загрузка файла
 */
public class LoadFile {
	
	//Ссылка на файл
	private File fin;	
	//Коллекция хранящяя словарь
	private List<String> listFile;
	//сканнер для считывания текста с файла
	private Scanner sc;
	
	/**
	 * Конструктор принимающий имя файла
	 */
	public LoadFile (String nameFile) {
		listFile = new ArrayList<>();
		fin = new File(nameFile);
	}
	
	/**
	 * Cчитываем текст с файла в список
	 */
	public List<String> getList() throws FileNotFoundException {					
		sc = new Scanner(fin);
		System.out.println("-------------Исходный текст-------------");
		String temp;
		while (sc.hasNextLine()) {
			temp = sc.nextLine();
			System.out.println(temp);
			listFile.add(temp);
		}
		sc.close();	
		return listFile;
	}
}
