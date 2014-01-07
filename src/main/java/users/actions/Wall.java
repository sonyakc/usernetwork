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
		String username = split[0];
		User user = lookupUser(username);
		List<Tweet> tweets = user.tweets();
		for(Tweet tw : tweets) {
			print(tw.message());
		}
	}

}
