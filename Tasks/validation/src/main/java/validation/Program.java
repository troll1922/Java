package validation;

/**
 * Программа Validation
 * @author Aleksey Fomichev
 */
public class Program {

		public static void main(String[] args) {
			PrintConsole pr = new PrintConsole();
			pr.start();
			String str = pr.getString();
			Validation valid = new Validation();
			pr.outResult(valid.getSolve(str));
		}
}