package users.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a tweet composed of the following
 * - message posted
 * - time message was posted
 * 
 * @author Sonya
 *
 */
@XmlRootElement
public class Tweet {
	public Tweet() {
	}
	public Tweet(String message, Date timePosted) {
		this.message = message;
		this.timePosted = timePosted;
	}
	private String message;
	private Date timePosted;
	/**
	 * @return the message
	 */
	public String message() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the timePosted
	 */
	public Date timePosted() {
		return timePosted;
	}
	/**
	 * @param timePosted the timePosted to set
	 */
	public void setTimePosted(Date timePosted) {
		this.timePosted = timePosted;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result
				+ ((timePosted == null) ? 0 : timePosted.hashCode());
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
		Tweet other = (Tweet) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (timePosted == null) {
			if (other.timePosted != null)
				return false;
		} else if (!timePosted.equals(other.timePosted))
			return false;
		return true;
	}
}