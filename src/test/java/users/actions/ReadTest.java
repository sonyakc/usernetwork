package users.actions;

import static org.mockito.Mockito.*;

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

public class ReadTest {

	@Spy
	private IPrinter printer = new SystemPrinter();
	
	@Mock
	private IUserDao dao;
	
	private Read read;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		
		read = new Read();
		read.setUserDao(dao);
		read.setPrinter(printer);
	}
	
	@Test
	public void shouldOutputTweets() throws UserDoesNotExistException {
		// Given
		whenQueryForAlice();
		
		// When
		read.execute("Alice");
		
		// Then
		verify(printer, times(2)).print(anyString());
	}

	private void whenQueryForAlice() {
		List<Tweet> tweets = new ArrayList<>();
		tweets.add(new Tweet("Its snowing outside", new Date()));
		tweets.add(new Tweet("I forgot my wallet at home", new Date()));
		User user = new User("Alice", tweets, new ArrayList<User>());
		when(dao.findUser("Alice")).thenReturn(user);
	}
	
	@Test
	public void shouldNotOutputTweets() throws UserDoesNotExistException {
		// Given
		User user = new User("Alice",  new ArrayList<Tweet>(), new ArrayList<User>());
		when(dao.findUser("Alice")).thenReturn(user);
		
		// When
		read.execute("Alice");
		
		// Then
		verify(printer, never()).print(anyString());
	}
	
	@Test(expected = UserDoesNotExistException.class)
	public void userDoesNotExistNoTweets() throws UserDoesNotExistException {
		// Given
		when(dao.findUser("Sumeet")).thenReturn(null);
		
		// When
		read.execute("Sumeet");
	}
}
