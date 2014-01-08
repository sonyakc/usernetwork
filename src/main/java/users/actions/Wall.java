package users.actions;

import java.util.List;

import users.domain.Tweet;
import users.domain.User;

/**
 * View messages posted to a user's wall
 * 
 * @author Sonya
 *
 */
public class Wall extends CommandAction {

	@Override
	public void execute(String command) {
		String[] split = command.split("wall");
		String username = split[0].trim();
		User user = lookupUser(username);
		publishTweets(user);
		subscribedTweets(user);
	}

	private void subscribedTweets(User user) {
		List<User> following = user.following();
		for(User followingUser : following) {
			publishTweets(followingUser);
		}
	}

	private void publishTweets(User user) {
		List<Tweet> tweets = user.tweets();
		for(Tweet tw : tweets) {
			print(user.name() + " - " + tw.message() + getTimeDifference(tw.timePosted()));
		}
	}
}
