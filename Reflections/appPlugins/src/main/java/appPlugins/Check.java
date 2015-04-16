package appPlugins;

/**
 * Проверка ввода данных пользователя с консоли
 */
public class Check {
	
	
	public boolean checking (String[] args) {
		if (!(args.length==2)) {
			System.out.println("Ошибка: в командной строке должно быть 2 аргумента");
			return false;
		}
			else if (!((args[0].endsWith(".txt"))&&(args[1].endsWith(".jar")))) {
				System.out.println("Ошибка: первый файл д.б. с расширением .txt, второй .jar");
				return false;
			}
				else {
					return true;
				}
	}
}