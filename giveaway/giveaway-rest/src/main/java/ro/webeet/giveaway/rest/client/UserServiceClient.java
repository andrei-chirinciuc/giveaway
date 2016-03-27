package ro.webeet.giveaway.rest.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.PagedResources.PageMetadata;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.client.Traverson;
import org.springframework.hateoas.client.Traverson.TraversalBuilder;
import org.springframework.hateoas.mvc.TypeReferences.PagedResourcesType;

import ro.webeet.giveaway.persistence.model.User;
import ro.webeet.giveaway.rest.dto.user.AuthenticationDTO;
import ro.webeet.giveaway.util.endpoints.InternalEndpoint;

public class UserServiceClient extends RestClientTemplate{

	private static final long serialVersionUID = -5477998302135844540L;

	private static final Logger log = LoggerFactory.getLogger(UserServiceClient.class);

	public User get(final Long id) {
		log.debug("UserServiceClient:get user id:{}", id);
		return getTemplate().getForObject(
				InternalEndpoint.PERSISTENCE.getEndpointAddress().append("user/{id}").toString(), User.class, id);
	}

	public void save(final User user) {
		log.debug("UserServiceClient:save user '{}'", user.getEmail());
		getTemplate().put(InternalEndpoint.PERSISTENCE.getEndpointAddress().append("user").toString(), user);
	}

	public void delete(final User user) {
		log.debug("UserServiceClient:delete user :{}", user);
		getTemplate()
				.put(InternalEndpoint.PERSISTENCE.getEndpointAddress().append("user/delete/").toString(), user);
	}

	public User authenticate(final AuthenticationDTO authenticationDTO){
		log.debug("UserServiceClient:authenticate");
		return getTemplate().postForObject(
				InternalEndpoint.PERSISTENCE.getEndpointAddress().append("user/authenticate").toString(),
				authenticationDTO, User.class);
	}

	public Long count() {
		log.debug("UserServiceClient:count");
		return getTemplate().getForObject(InternalEndpoint.PERSISTENCE.getEndpointAddress().append("count").toString(),
				Long.class);
	}

	public List<User> findAll(Long pageStart, Long pageSize, String sortBy, Boolean ascending) {
		log.debug("UserServiceClient:findAll");

		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("page", pageStart == null ? 0 : pageStart);
		parameters.put("size", pageSize == null ? 10000 : pageSize);
		parameters.put("sort", sortBy + (ascending ? ",asc" : ",desc"));

		// Set up path traversal
		final URI uri = URI.create(InternalEndpoint.PERSISTENCE.getEndpointAddress().append("data").toString());

		final Traverson traverson = new Traverson(uri, MediaTypes.HAL_JSON);
		final TraversalBuilder builder = traverson.follow("users").withTemplateParameters(parameters);
		final PagedResources<Resource<User>> resources = builder.toObject(new PagedResourcesType<Resource<User>>() {
		});

		final PageMetadata metadata = resources.getMetadata();

		log.info("Got {} of {} users: ", resources.getContent().size(), metadata.getTotalElements());

		final List<User> users = new ArrayList<User>();
		StreamSupport.stream(resources.spliterator(), false).//
		map(Resource::getContent).//
		forEach(user -> {
			users.add(user);
		});

		return users;
	}


}
