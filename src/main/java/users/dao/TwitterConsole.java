package users.dao;

import java.util.Scanner;

public class TwitterConsole {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		emptyUserDao();
		
		try(Scanner scanner = new Scanner(System.in)) {
			String next = scanner.next();
		}
	}

	private static IUserDao emptyUserDao() {
		return new UserDao();
	}

}
