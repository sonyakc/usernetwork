package users.actions;

/**
 * Print messages out to standard output stream
 * @author Sonya
 *
 */
public class SystemPrinter implements IPrinter {

	@Override
	public void print(String message) {
		System.out.println(message);
	}

}
