package appPlugins;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lib.IPlugin;
import lib.InitPlugin;
import lib.ProcessPlugin;
import lib.DestroyPlugin;

/**
 * Программа по работе с плагинами с помощью reflection
 * @author Aleksey Fomichev
 */
public class AppPlugins {
		public static void main(String[] args) throws ClassNotFoundException,
				FileNotFoundException, IOException, InstantiationException,
				IllegalAccessException, IllegalArgumentException, InvocationTargetException {
			
			//проверка ввода данных пользователя с консоли
			Check check = new Check();	
			if (!(check.checking(args))) return;
			//загружаем модуль
			LoadModule jarClassLoader = new LoadModule(args[1]);  
			//получаем класс из модуля
			Class<?> classModule = jarClassLoader.getClassPlugin();  
			//проверяем найден ли в .jar файле класс имплементирующий IPlugin
			if (classModule == null) return; 
			//создаем объект класса имплементирующий IPlugin
			IPlugin objModule = (IPlugin) classModule.newInstance();  
			//получаем все методы загруженного класса
			Method[] method = classModule.getMethods();
			//создаем переменные, в которых будут храниться ссылки на методы
			Method methodInit = null, methodProcess = null, methodDestroy = null;
			//перебираем все методы, занося в переменные требуемый метод
			for (Method md: method){
				if (md.isAnnotationPresent(InitPlugin.class)) {
					methodInit = md;
				}
				if (md.isAnnotationPresent(ProcessPlugin.class)) {
					methodProcess = md;
				}
				if (md.isAnnotationPresent(DestroyPlugin.class)) {
					methodDestroy = md;
				}
			}
			//вызываем метод Init
			methodInit.invoke(objModule);
			//загружаем файл с текстом
			LoadFile file = new LoadFile(args[0]);
			//создаем список в котром будет храниться текст
			List<String> listFile = new ArrayList<>(); 
			listFile = file.getList(); 
			Iterator<String> iter = listFile.iterator();
			//перебираем построчно текст, вызывая метод Process у модуля
			while (iter.hasNext()) {
				methodProcess.invoke(objModule, iter.next());
				
			}
			//вызываем метод Destroy
			methodDestroy.invoke(objModule);		
		}
}