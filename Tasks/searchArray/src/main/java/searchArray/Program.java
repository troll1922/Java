package searchArray;

/**
 * Программа SearchArray
 * @author Aleksey Fomichev
 */
public class Program {

		public static void main(String[] args) {
			PrintConsole pr = new PrintConsole();
			pr.start();
			int size = pr.getSize();
			SearchArray search = new SearchArray();
			search.generateArray(size);
			search.scan();
			pr.outResult(search.getOne(), search.getTwo());
		}
}