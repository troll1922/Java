package jUnitProgram;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lib.IPlugin;
import lib.ProcessPlugin;

/**
 * Программа по работе с плагинами с помощью reflection
 * @author Aleksey Fomichev
 */
public class Program {
	
	private final static Logger logger = LoggerFactory.getLogger(Program.class);
	
		public static void main(String[] args) throws ClassNotFoundException,
				FileNotFoundException, IOException, InstantiationException,
				IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException {
			
			logger.info("Entering application.");

			/**
			 * Проверка переданных аргументов в консоли 
			 */
			Check check = new Check();
			if (!(check.checking(args))) return;
			
			//создаем map, хранящий имя и строки файла
			Map<String, List<String>> mapFiles = new HashMap<>();	
			//загружаем модуль
			LoadModule jarClassLoader = new LoadModule(args[0]);  
			//получаем класс имплементирующий IPlugin из модуля
			Class<?> classModule = jarClassLoader.getClassPlugin();  
			//проверяем найден ли в .jar файле класс имплементирующий IPlugin
			if (classModule == null) {
				return;
			}
			//создаем объект класса имплементирующий IPlugin
			IPlugin objModule = (IPlugin) classModule.newInstance();  
			//получаем все методы загруженного класса
			Method[] method = classModule.getMethods();
			//создаем переменные, в которых будут храниться ссылки на методы
			Method methodProcess = null;
			//перебираем все методы, занося в переменные требуемый метод
			for (Method md: method){
				if (md.isAnnotationPresent(ProcessPlugin.class)) {
					methodProcess = md;
				}
			}		
			//загружаем текстовые файлы
			LoadFiles files = new LoadFiles();
			mapFiles = files.getMap();
			//создадим каталог для новых файлов
			File dir = new File("modFile");
			dir.mkdirs();
			Iterator<Map.Entry<String, List<String>>> iter = mapFiles.entrySet().iterator();
			//создаем пул потоков
			ExecutorService exec = Executors.newCachedThreadPool();
			while (iter.hasNext()) {
				Map.Entry<String, List<String>> entry = iter.next();
				exec.execute(new ThreadFiles (entry.getKey(), entry.getValue(), objModule, methodProcess));
			}
			exec.shutdown();	//остановка потоков, после выполнения последнего задания
			while (!exec.isTerminated()) {}
			ThreadFiles.infoStatistic();	//выводим общую информацию об обработанных файлах
			logger.info("Exiting application.");
		};		
}