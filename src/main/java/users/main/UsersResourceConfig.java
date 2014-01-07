package users.main;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import users.dao.IUserDao;


public class UsersResourceConfig extends ResourceConfig {

	/**
	 *
	 */
	public UsersResourceConfig() {
		register(new AbstractBinder() {
            @Override
            protected void configure() {
                bindFactory(UserDaoFactory.class).to(IUserDao.class);
            }
        });
	}


}
