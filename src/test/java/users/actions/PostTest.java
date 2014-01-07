package users.actions;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import users.dao.UserDao;
import users.domain.Tweet;
import users.domain.User;

public class PostTest {

	private Post post;
	
	@Before
	public void setup() {
		post = new Post();
		// can use a new dao for this test case as user is posting tweets
		post.setUserDao(new UserDao());
	}
	
	@Test
	public void alicePostsTweetToTimeline() {
		post.execute("Alice -> I love the weather today");
		User user = post.lookupUser("Alice");
		Tweet tweet = user.tweets().get(0);
		Assert.assertEquals("I love the weather today", tweet.message());
		Assert.assertNotNull(new Date().getTime() - tweet.timePosted().getTime());
	}

}
