package threadProgram;

/**
 * Проверка переданных аргументов в консоли
 */
public class Check {
	
	/**
	 * Конструктор
	 */
	public Check(){
	}
	
	public boolean checking (String[] args) {
		if (!(args.length==1)) {
			System.out.println("Ошибка: в командной строке должен быть 1 аргумент");
			return false;
		}
			else if (!(args[0].endsWith(".jar"))) {
				System.out.println("Ошибка: файл д.б. с расширением .jar");
				return false;
			}
				else {
					return true;
				}
	}
}