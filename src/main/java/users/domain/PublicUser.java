package users.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PublicUser {
	public PublicUser(PublicUserBuilder builder) {
		this.fullName = builder.getFullname();
		this.description = builder.getDescription();
		this.username = builder.getUsername();
	}
	private String fullName;
	private String description;
	private String username;
	
	public PublicUser() {
	}
	public String getFullName() {
		return fullName;
	}
	public String getDescription() {
		return description;
	}
	public String getUsername() {
		return username;
	}
}
