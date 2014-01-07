package users.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="PROFILE")
public class Profile {
	
	@Id
    @GeneratedValue
	@Column(name = "PROFILE_ID")
	private Integer id;
	
	@Column(name = "PROTECTED")
	private Boolean isProtected;
	
	@Column(name = "FOLLOW")
	private Boolean follow;
}
