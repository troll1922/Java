package factorial;

/**
 * Программа Factorial
 * @author Aleksey Fomichev
 */
public class Program {

		public static void main(String[] args) {
			PrintConsole pr = new PrintConsole();
			pr.start();
			int value = pr.getValue();
			Factorial factorial = new Factorial();
			pr.outResult(factorial.getSolve(value));
		}
}