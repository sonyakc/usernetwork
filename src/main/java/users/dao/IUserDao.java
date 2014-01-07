package users.dao;

import java.util.List;

import users.domain.User;


public interface IUserDao {

	/**
	 * Returns all users
	 * @return
	 */
	 List<User> allUsers();

	/**
	 * Creates a new user with provided name
	 * 
	 * @param name
	 * @return
	 */
	 User createUser(String name);

	/**
	 * Finds a new user
	 * 
	 * @param username
	 * @return
	 */
	 User findUser(String username);
}