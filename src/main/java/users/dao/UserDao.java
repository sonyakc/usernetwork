package users.dao;

import java.util.ArrayList;
import java.util.List;

import users.domain.User;


/**
 * Data access layer for @User Create-Read-Update-Delete CRUD
 * 
 * @author Sonya
 *
 */
public class UserDao implements IUserDao {

	public UserDao() {
		this.users = new ArrayList<User>();
	}

	private List<User> users;
	
	/* (non-Javadoc)
	 * @see main.IUserDao#allUsers()
	 */
	@Override
	public List<User> allUsers() {
		return users;
	}
	
	/* (non-Javadoc)
	 * @see main.IUserDao#createUser(java.lang.String)
	 */
	@Override
	public User createUser(String name) {
		User newUser = new User();
		newUser.setName(name);
		users.add(newUser);
		
		return newUser;
	}

	/* (non-Javadoc)
	 * @see main.IUserDao#findUser(java.lang.String)
	 */
	@Override
	public User findUser(String username) {
		for(User user : users) {
			if(username.equals(user.name())) {
				return user;
			}
		}
		return null;
	}

}
