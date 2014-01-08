package users.dao;

import java.util.Scanner;

import users.actions.CommandAction;
import users.actions.Follow;
import users.actions.IPrinter;
import users.actions.Post;
import users.actions.Read;
import users.actions.SystemPrinter;
import users.actions.UserDoesNotExistException;
import users.actions.Wall;

public class TwitterConsole {

	/**
	 * @param args
	 * @throws UserDoesNotExistException 
	 */
	public static void main(String[] args) throws UserDoesNotExistException {
		IUserDao dao = new UserDao();
		IPrinter printer = new SystemPrinter();
		
		CommandAction post = new Post();
		post.setUserDao(dao);
		post.setPrinter(printer);
		
		CommandAction read = new Read();
		read.setUserDao(dao);
		read.setPrinter(printer);
		
		CommandAction follow = new Follow();
		follow.setUserDao(dao);
		follow.setPrinter(printer);
		
		CommandAction wall = new Wall();
		wall.setUserDao(dao);
		wall.setPrinter(printer);
		
		try(Scanner scanner = new Scanner(System.in)) {
			scanner.useDelimiter(">");
			while(scanner.hasNext()) {
				String command = scanner.nextLine();
				
				if(command.contains("->")) {
					post.execute(command);
				} else if(command.contains("follows")) {
					follow.execute(command);
				} else if(command.contains("wall")) {
					wall.execute(command);
				} else { // its read!
					read.execute(command);
				}
			}
		}
	}


}
