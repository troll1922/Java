package jUnitProgram;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lib.TypeAnnotation;

/**
 * Реализуем собственный загрузчик классов
 */
public class LoadModule extends ClassLoader {
	
	private final static Logger logger = LoggerFactory.getLogger(LoadModule.class);
	//имя .jar файла
	private String jarFileName;
	
	/**
	 * Консруктор принимающий имя .jar файла
	 */
	public LoadModule (String jarFileName) {
		this.jarFileName = jarFileName;
	}
	
	/**
	 * Извлекаем класс имплементирующий IPlugin из .jar файла
	 */
	public Class<?> getClassPlugin() {
		JarFile jarFile;
		try {
			jarFile = new JarFile(jarFileName);
			Enumeration<JarEntry> entries = jarFile.entries();
			while (entries.hasMoreElements()) {
				JarEntry jarEntry = (JarEntry) entries.nextElement();
				if ((jarEntry.getName().replace('/', '.')).endsWith(".class")) {
					byte[] classData = loadClassData(jarFile, jarEntry);
					if (classData != null) {					
						Class<?> cl = defineClass(
								stripClassName(jarEntry.getName().replace('/', '.')),
								classData, 0, classData.length);
							//находим класс по аннотации
							if (cl.isAnnotationPresent(TypeAnnotation.class)) {  
								jarFile.close();
								return cl;
							}
						}
						logger.error("Класс имплементирующий IPlugin в .jar файле не найден");
						jarFile.close();
						return null;
					}
				}
		}
		catch (IOException IOE) {
			logger.error(IOE.getMessage());
		}
		logger.error("Класс имплементирующий IPlugin в .jar файле не найден");
		return null;
	}
	
	/**
	 * Получаем имя класса без расширения .class
	 */
	public String stripClassName(String className) {
		return className.substring(0, className.length() - 6);

	}
	
	/**
	 * Считываем класс по байту
	 */
	private byte[] loadClassData(JarFile jarFile, JarEntry jarEntry)
			throws IOException {
		long size = jarEntry.getSize();
		if (size <= 0)
			return null;
		byte[] data = new byte[(int) size];
		InputStream in = jarFile.getInputStream(jarEntry);
		in.read(data);
		return data;
	}
}