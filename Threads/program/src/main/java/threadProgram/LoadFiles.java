package threadProgram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Загрузка файла
 */
public class LoadFiles {

	/**
	 * Конструктор
	 */
	public LoadFiles() {
	}
	
	/**
	 * Cчитываем текстовые файлы
	 */
	public Map<String, List<String>> getMap() throws IOException {	
		
		Map<String, List<String>> mapFiles = new HashMap<>();
		List <String> strList; 
		String list[] = new File(".").list();
		for(int i = 0; i < list.length; i++) {
			if (list[i].endsWith(".txt")) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(list[i]), "Cp1251"));
				strList = new ArrayList<>();
				String line;
				while ((line = reader.readLine()) != null) {
					String str = line;
					strList.add(str);
				}
				mapFiles.put(list[i], strList);
				reader.close();
			}
		}
		return mapFiles;
	}
}
