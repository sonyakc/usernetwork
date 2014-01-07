package users.actions;

import users.domain.User;

public class Follow extends CommandAction {

	@Override
	public void execute(String command) {
		String[] split = command.split("follows");
		String username = split[0].trim();
		String anotherUser = split[1].trim();
		
		User user = lookupUser(username);
		User userToFollow = lookupUser(anotherUser);

		user.following(userToFollow);
	}

}
