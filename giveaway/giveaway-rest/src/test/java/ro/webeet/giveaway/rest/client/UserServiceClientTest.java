package ro.webeet.giveaway.rest.client;

import static org.junit.Assert.assertNotNull;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;

import ro.webeet.giveaway.persistence.model.User;
import ro.webeet.giveaway.persistence.model.property.UserType;
import ro.webeet.giveaway.rest.client.UserServiceClient;

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

}
