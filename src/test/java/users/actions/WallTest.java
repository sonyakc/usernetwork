package users.actions;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import users.dao.IUserDao;

public class WallTest {
	private Wall wall;
	
	@Mock
	private IUserDao dao;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		wall = new Wall();
		wall.setUserDao(dao);
	}
}
