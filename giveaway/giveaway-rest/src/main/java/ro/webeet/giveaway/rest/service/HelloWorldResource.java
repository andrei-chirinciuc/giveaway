package ro.webeet.giveaway.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import ro.webeet.giveaway.persistence.service.UserService;

@Path("hello")
public class HelloWorldResource {

	@Autowired
	private UserService service;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getHello() {
		return String.valueOf(service.count());
	}
}

