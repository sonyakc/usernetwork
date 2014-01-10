package users.actions;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import users.dao.IUserDao;
import users.dao.UserDao;
import users.domain.User;

public class FollowTest {

	private Follow follow;
	
	private IUserDao dao;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		follow = new Follow();
		dao = new UserDao();
		initDao();
		follow.setUserDao(dao);
	}
	
	private void initDao() {
		dao.createUser("Alice");
		dao.createUser("Sonya");
	}

	@Test
	public void aliceFollowsSonya() throws TwitterActionFailedException {
		follow.execute("Alice follows Sonya");
		User alice = dao.findUser("Alice");
		List<User> following = alice.following();
		Assert.assertEquals("Sonya", following.get(0).name());
		
		User sonya = dao.findUser("Sonya");
		Assert.assertTrue(sonya.following().isEmpty());
	}
	
	@Test
	public void sonyaFollowsAlice() throws TwitterActionFailedException {
		follow.execute("Sonya follows Alice");
		User sonya = dao.findUser("Sonya");
		List<User> following = sonya.following();
		Assert.assertEquals("Alice", following.get(0).name());
		
		User alice = dao.findUser("Alice");
		Assert.assertTrue(alice.following().isEmpty());
	}
	
	@Test(expected = TwitterActionFailedException.class)
	public void cannotFollowInvalidUser() throws TwitterActionFailedException {
		follow.execute("Sonya follows");
	}
}
