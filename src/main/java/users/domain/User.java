package users.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a user in our virtual world
 * 
 * @author Sonya
 *
 */
@XmlRootElement
public class User {
	public User() {
	}
	public User(String name, List<Tweet> tweets, List<User> following) {
		this.name = name;
		this.tweets = tweets;
		this.following = following;
	}
	private String name;
	private List<Tweet> tweets = new ArrayList<Tweet>();
	private List<User> following = new ArrayList<User>();
	/**
	 * @return the name
	 */
	public String name() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the tweets
	 */
	public List<Tweet> tweets() {
		return tweets;
	}
	/**
	 * @return the following
	 */
	public List<User> following() {
		return following;
	}
	/**
	 * @param following the following to set
	 */
	public void setFollowing(List<User> following) {
		this.following = following;
	}
	/**
	 * Posts a tweet mesage to user's timeline
	 * @param tweet
	 */
	public void postTweet(String tweet) {
		Tweet tweetPosting = new Tweet();
		tweetPosting.setMessage(tweet);
		tweetPosting.setTimePosted(new Date());
		this.tweets.add(tweetPosting);
	}
	/**
	 * Follow another user
	 * @param anotherUser
	 */
	public void following(User anotherUser) {
		this.following.add(anotherUser);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((following == null) ? 0 : following.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tweets == null) ? 0 : tweets.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (following == null) {
			if (other.following != null)
				return false;
		} else if (!following.equals(other.following))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tweets == null) {
			if (other.tweets != null)
				return false;
		} else if (!tweets.equals(other.tweets))
			return false;
		return true;
	}
}