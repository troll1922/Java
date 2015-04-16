package module1;

import lib.IPlugin;
import lib.ProcessPlugin;
import lib.TypeAnnotation;

/**
 * Плагин 1 
 * @author Aleksey Fomichev
 */
@TypeAnnotation (name="module1")
public class Module1 implements IPlugin {

	@ProcessPlugin
	@Override
	public String process(String str) {
		
		String arr [] = (str.split(" "));
		StringBuilder strBild = new StringBuilder();
		for (int i=0; i<arr.length; i+=2) {
			strBild.append(arr[i]).append(" ");
		}
		return strBild.toString();
	}
}
