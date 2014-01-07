package users.main;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import users.main.Main;


public class UsersResourceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client client = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = client.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }
    
    @Test
    public void getUserById() {
        Response response = target.path("users/123").request().get();
    	assertEquals(200, response.getStatus());
    	System.out.println(response.readEntity(String.class));
    }
    
    @Test
    public void getUsers() {
        Response response = target.path("users").request().get();
    	assertEquals(200, response.getStatus());
    	System.out.println(response.readEntity(String.class));
    }
}
