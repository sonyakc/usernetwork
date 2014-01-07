package users.actions;

import users.domain.User;

/**
 * Posts a message to user's timeline
 * @author Sonya
 *
 */
public class Post extends CommandAction {
	
	/**
	 * Expected format is:
	 * �	posting: '<user name> -> <message>'
	 */
	@Override
	public void execute(String command) {
		String[] split = command.split("->");
		String username = split[0].trim();
		String tweet = split[1].trim();
		
		User user = lookupUser(username);
		user.postTweet(tweet);
	}

}
