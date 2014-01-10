package users.actions;

public class TwitterActionFailedException extends Exception {

	private String message;

	public TwitterActionFailedException(String msg) {
		this.setMessage(msg);
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
