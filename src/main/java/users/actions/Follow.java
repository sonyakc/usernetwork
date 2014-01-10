package users.actions;

import users.domain.User;

public class Follow extends CommandAction {

	@Override
	public void execute(String command) throws TwitterActionFailedException {
		String[] split = command.split("follows");
		if(split == null) {
			throw new TwitterActionFailedException("follow command is not valid");
		}
		if(split.length != 2) {
			throw new TwitterActionFailedException("follow command is not valid");
		}
		
		String username = split[0].trim();
		String anotherUser = split[1].trim();
		
		User user = lookupUser(username);
		User userToFollow = lookupUser(anotherUser);

		user.following(userToFollow);
	}

}