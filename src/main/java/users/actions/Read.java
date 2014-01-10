package users.actions;

import java.util.List;

import users.domain.Tweet;
import users.domain.User;


/**
 * Read a user's timeline
 * 
 * @author Sonya
 *
 */
public class Read extends CommandAction {
	
	@Override
	public void execute(String command) throws TwitterActionFailedException {
		User user = lookupUser(command);
		if(user == null) {
			throw new TwitterActionFailedException("Cannot read tweets for invalid username");
		}
		List<Tweet> tweets = user.tweets();
		for(Tweet tw : tweets) {
			print(user.name() + " - " + tw.message() + getTimeDifference(tw.timePosted()));
		}
	}
}
