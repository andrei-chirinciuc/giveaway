package ro.webeet.giveaway.rest.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.PagedResources.PageMetadata;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.client.Traverson;
import org.springframework.hateoas.client.Traverson.TraversalBuilder;
import org.springframework.hateoas.mvc.TypeReferences.PagedResourcesType;

import ro.webeet.giveaway.persistence.model.User;
import ro.webeet.giveaway.persistence.model.property.UserType;
import ro.webeet.giveaway.util.endpoints.InternalEndpoint;

public class UserServiceClientTest {

	private final UserServiceClient client = new UserServiceClient();

	@Test
	public void testGetUser() {
		final User user = client.get(1l);
		System.err.println(ReflectionToStringBuilder.toString(user));
		assertNotNull(user);
	}

	@Test
	public void testAddUser() {
		final User user = new User();
		user.setEmail("test@email.com");
		user.setPassword("test");
		user.setName("John Test");
		user.setTelephone("000-000-0000");
		user.setAdminFlag(false);
		user.setUserType(UserType.PERSON);
		user.setAge(18);
		// user.setAddress(address);
		client.save(user);
	}

	@Test
	public void testGetUsers() {
		final URI uri = URI.create(InternalEndpoint.PERSISTENCE.getEndpointAddress().append("data").toString());

		// return users.getContent();
		final Traverson traverson = new Traverson(uri, MediaTypes.HAL_JSON);

		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("size", 1);

		// Set up path traversal
		final TraversalBuilder builder = traverson.follow("users").withTemplateParameters(parameters);
		final PagedResources<Resource<User>> resources = builder.toObject(new PagedResourcesType<Resource<User>>() {
		});

		final PageMetadata metadata = resources.getMetadata();
		System.err.println("METADATA size->" + metadata.getSize());

		final List<User> users = new ArrayList<User>();
		StreamSupport.stream(resources.spliterator(), false).//
		map(Resource::getContent).//
		forEach(user -> {
			users.add(user);
		});

		assertTrue(resources.getContent().size() + " users found instead of 2", users.size() == 1);
	}

}
