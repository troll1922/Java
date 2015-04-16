package jUnitProgram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Загрузка файла
 */
public class LoadFiles { 
	
	private final static Logger logger = LoggerFactory.getLogger(LoadModule.class);

	/**
	 * Cчитываем текстовые файлы
	 */
	public Map<String, List<String>> getMap() {	
		
		Map<String, List<String>> mapFiles = new HashMap<>();
		List <String> strList; 
		String list[] = new File(".").list();
		for(int i = 0; i < list.length; i++) {
			if (list[i].endsWith(".txt")) {
				BufferedReader reader = null;
				try {
					reader = new BufferedReader(new InputStreamReader(new FileInputStream(list[i]), "Cp1251"));
				} 
				catch (UnsupportedEncodingException e) {
					logger.error(e.getMessage());	
				} 
				catch (FileNotFoundException e) {
					logger.error(e.getMessage());
				}
				strList = new ArrayList<>();
				String line;
				try {
					while ((line = reader.readLine()) != null) {
						String str = line;
						strList.add(str);
					} 
				mapFiles.put(list[i], strList);
				reader.close();
				} 
				catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
		}
		return mapFiles;
	}
}
