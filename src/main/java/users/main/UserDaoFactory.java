package users.main;

import org.glassfish.hk2.api.Factory;

import users.dao.IUserDao;
import users.dao.UserDao;


public class UserDaoFactory implements Factory<IUserDao> {

	@Override
	public void dispose(IUserDao dao) {
		// no-op
	}

	@Override
	public IUserDao provide() {
		return new UserDao();
	}

}
