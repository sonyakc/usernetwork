package users.domain;

public class PublicUserBuilder implements IBuilder<PublicUser> {

	public PublicUserBuilder(String username, String description,
			String fullname) {
		super();
		this.username = username;
		this.description = description;
		this.fullname = fullname;
	}

	private String username;
	private String description;
	private String fullname;

	public String getUsername() {
		return username;
	}

	public String getDescription() {
		return description;
	}

	public String getFullname() {
		return fullname;
	}

	public IBuilder<PublicUser> withUserName(String username) {
		this.username = username;
		return this;
	}
	
	public IBuilder<PublicUser> withDescription(String description) {
		this.description = description;
		return this;
	}
	
	public IBuilder<PublicUser> withFullName(String fullname) {
		this.fullname = fullname;
		return this;
	}

	@Override
	public PublicUser build() {
		return new PublicUser(this);
	}
	
}


