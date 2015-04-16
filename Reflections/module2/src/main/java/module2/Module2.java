package module2;

import lib.DestroyPlugin;
import lib.IPlugin;
import lib.InitPlugin;
import lib.ProcessPlugin;
import lib.TypeAnnotation;

/**
 * Плагин 2 
 * @author Aleksey Fomichev
 */

@TypeAnnotation (name="module2")
public class Module2 implements IPlugin {
	
	//переменная для ввода информации метода Process
	private static boolean start = true;
	
	@Override
	@InitPlugin
	public void init() {
		System.out.println("Work module 2");	
	}

	@Override
	@ProcessPlugin
	public void process(String str) {
		if (start) {
			System.out.println("--------Удаляем двойные пробелы--------");
			start = false;
		}
		System.out.println(str.replace("  "," "));
	}

	@Override
	@DestroyPlugin
	public void destroy() {
		System.out.println("End module 2");
	};
}
