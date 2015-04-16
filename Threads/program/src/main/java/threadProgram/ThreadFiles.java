package threadProgram;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import lib.IPlugin;


public class ThreadFiles extends Thread {
	
	private String nameFile;
	private static int countFiles;	//кол-во обработанных файлов
	private static int countStrings;	//кол-во обработанных строк в файлах
	private static int countWords;	//кол-во удаленных слов в файлах
	private int words;	//кол-во удаленных слов в одном файлах
	private List <String> strList2;
	private IPlugin objModule;
	private Method md;
	
	public ThreadFiles(String nameFile, List<String> strList2, IPlugin objModule, Method md) {
		this.strList2 = strList2;
		this.nameFile = nameFile;
		this.objModule = objModule;
		this.md = md;
		strList2 = new ArrayList<>();
	}
	
	/**
	 * Запуск потока, в котором обрабатываются файлы
	 */
	public void run() {
		int size = strList2.size();//кол-во строк в файле
		int count = 1;//подсчет обработанных строк
		System.out.println("Начало обработки файла " + "\"" + nameFile + "\"");
		BufferedWriter writer=null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("modFile/" + nameFile + "_Mod" + ".txt"), "Cp1251"));
		} 
		catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} 
		catch (FileNotFoundException e1) {
		
			e1.printStackTrace();
		}

		for (String tmp : strList2) {
			try {
				String str = (String) md.invoke(objModule, tmp);	//вызов модуля по обработке строки
				writer.write(str);
				writer.newLine();
			    if ((count)==size/2) {
			    	System.out.println("Обработано 50% текста файла " + "\"" + nameFile + "\"");
			    }
			    count++;	//подсчет обработанных строк
			    words+=(str.split(" ")).length;	//кол-во удаленных слов в файлах
			} 
			catch (IllegalAccessException e) {
				e.printStackTrace();
			} 
			catch (IllegalArgumentException e) {
				e.printStackTrace();
			} 
			catch (InvocationTargetException e) {
				e.printStackTrace();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			System.out.println("Обработка файла " + "\"" + nameFile + "\"" + " завершена");
			writer.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		statistic ();
	}
	
		/**
		 * Обработка информации
		 */
		public void statistic() {
			countFiles++;
			countStrings+=strList2.size();
			countWords+=words;//кол-во удаленных слов в файлах
		} 
		
		/**
		 * Вывод статистики
		 */
		public static void infoStatistic() {
			System.out.println("Статистика:");
			System.out.println("----------- " + "1) Количество обработанных файлов = " + countFiles);
			System.out.println("----------- " + "2) Количество обработанных строк = " + countStrings);
			System.out.println("----------- " + "3) Количество удаленных слов = " + countWords);
		} 
}



