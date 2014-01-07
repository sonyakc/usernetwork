package users.main;

import static javax.ws.rs.core.MediaType.*;

import java.util.ArrayList;
import java.util.List;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.process.internal.RequestScoped;

import users.dao.IUserDao;
import users.domain.PublicUser;
import users.domain.PublicUserBuilder;

@Path("users")
@RequestScoped
public class UsersResource {
	
	// Allows to insert contextual objects into the class, 
	// e.g. ServletContext, Request, Response, UriInfo
	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;
	
	@Inject
	IUserDao dao;
	 
	@Path("{user : [0-9]*}")
	@GET
	@Produces( {APPLICATION_JSON})
	public Response getUserById(@PathParam("user") String id) {
		//TODO should find user with specified id
		final PublicUser publicUser = new PublicUserBuilder("Tweeter", "Me.Me.Me", "ABC ABC").build();
		return Response.ok(publicUser, APPLICATION_JSON).build();
	}
	
	@GET
	@Produces( {APPLICATION_JSON})
	public Response getsUsers() {
		//TODO should find user with specified id
		final PublicUser publicUser = new PublicUserBuilder("Tweeter", "Me.Me.Me", "ABC ABC").build();
		final PublicUser publicUser2 = new PublicUserBuilder("HelloBlah", "I.Tweedle.Me", "ABC ABC").build();
		List<PublicUser> users = new ArrayList<>();
		users.add(publicUser);
		users.add(publicUser2);
		return Response.ok(users, APPLICATION_JSON).build();
	}
	
}
