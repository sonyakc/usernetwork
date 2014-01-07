package users.actions;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import users.dao.IUserDao;

public class FollowTest {

	private Follow follow;
	
	@Mock
	private IUserDao dao;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		follow = new Follow();
		follow.setUserDao(dao);
	}
	
	@Test
	public void abc() {
		follow.execute(command)
	}
}
