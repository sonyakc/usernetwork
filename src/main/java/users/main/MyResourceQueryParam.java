package users.main;

import javax.ws.rs.QueryParam;

public class MyResourceQueryParam {
	@QueryParam("id")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
