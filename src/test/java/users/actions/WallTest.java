package users.actions;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import users.dao.IUserDao;
import users.domain.Tweet;
import users.domain.User;

public class WallTest {
	
	@Spy
	private IPrinter printer = new SystemPrinter();
	
	@Mock
	private IUserDao dao;

	private Wall wall;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		wall = new Wall();
		wall.setUserDao(dao);
		wall.setPrinter(printer);
	}
	
	@Test
	public void displayCharlieWall() {
		whenIQueryFor("Charlie");
		
		wall.execute("Charlie wall");
		
		verify(printer, times(4)).print(anyString());
	}

	private void whenIQueryFor(String username) {
		// username is following the following users
		User followingUser = following("Alice", "Hunger games is a great film");
		User additionalFollowing = following("Max", "Hunger games is a bad film");
		List<User> users = new ArrayList<User>();
		users.add(followingUser);
		users.add(additionalFollowing);
		
		// now construct the username user
		List<Tweet> tweets = new ArrayList<>();
		tweets.add(new Tweet("Its snowing outside", new Date()));
		tweets.add(new Tweet("I forgot my wallet at home", new Date()));
		User user = new User(username, tweets, users);
		when(dao.findUser(username)).thenReturn(user);
		
	}

	private User following(String username, String msg) {
		List<Tweet> tweets = new ArrayList<>();
		tweets.add(new Tweet(msg, new Date()));
		User user = new User(username, tweets, null);
		when(dao.findUser(username)).thenReturn(user);

		return user;
	}
}
