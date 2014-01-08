package users.actions;

import java.util.Date;

import users.dao.IUserDao;
import users.domain.User;

public abstract class CommandAction {
	private IUserDao dao;
	private IPrinter printer;

	/**
	 * Sets the action's dao
	 * @param userDao
	 */
	public void setUserDao(IUserDao userDao) {
		this.dao(userDao);
	}
	
	private IUserDao dao(IUserDao userDao) {
		this.dao = userDao;
		return this.dao;
	}
		
	/**
	 * Looks up user
	 * @param username
	 * @return
	 */
	public User lookupUser(String username) {
		User user = dao.findUser(username);
		if(user == null) {
			// return newly created user if user does not exist
			return dao.createUser(username); 
		}
		return user;
	}
	
	void print(String message) {
		printer.print(message);
	}

	public void setPrinter(IPrinter printer) {
		this.printer = printer;
	}
	
	public abstract void execute(String command) throws UserDoesNotExistException;
	
	@SuppressWarnings("deprecation")
	public final String getTimeDifference(Date timePosted) {
		long time = new Date().getMinutes() - timePosted.getMinutes();
		if(time == 0) {
			time = new Date().getSeconds() - timePosted.getSeconds();
			return " (" + time + " seconds ago)";
		}
		return " (" + time + " minutes ago)";
	}


}
