package jUnitProgram;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Проверка переданных аргументов в консоли
 */
public class Check {
	
	private final static Logger logger = LoggerFactory.getLogger(Check.class);
	
	//Проверка ввода данных с консоли
	public boolean checking (String[] args) {
		if (!(args.length==1)) {
			logger.error("Ошибка: в командной строке должен быть 1 аргумент");
			return false;
		}
			else if (!(args[0].endsWith(".jar"))) {
				logger.error("Ошибка: файл д.б. с расширением .jar");
				return false;
			}
				else {
					return true;
				}
	}
}