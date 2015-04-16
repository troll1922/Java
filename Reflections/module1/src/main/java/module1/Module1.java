package module1;

import lib.DestroyPlugin;
import lib.IPlugin;
import lib.InitPlugin;
import lib.ProcessPlugin;
import lib.TypeAnnotation;

/**
 * Плагин 1 
 * @author Aleksey Fomichev
 */
@TypeAnnotation (name="module1")
public class Module1 implements IPlugin {
	
	//переменная для ввода информации метода Process
	private static boolean start = true;
	
	@Override
	@InitPlugin
	public void init() {
		System.out.println("Work module 1");	
	}

	@Override
	@ProcessPlugin
	public void process(String str) {
		if (start) {
			System.out.println("--------Удаляем все слова через одно--------");
			start = false;
		}
		String arr [] = (str.replace("  "," ")).split(" ");
		StringBuilder strBild = new StringBuilder();
		for (int i=0; i<arr.length; i+=2) {
			strBild.append(arr[i]).append(" ");
		}
		System.out.println(strBild.toString());
	}

	@Override
	@DestroyPlugin
	public void destroy() {
		System.out.println("End module 1");
	};
}
