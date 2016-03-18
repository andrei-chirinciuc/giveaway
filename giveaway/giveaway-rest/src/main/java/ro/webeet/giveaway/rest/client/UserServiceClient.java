package ro.webeet.giveaway.rest.client;

import ro.webeet.giveaway.persistence.model.User;
import ro.webeet.giveaway.rest.dto.user.AuthenticationDTO;
import ro.webeet.giveaway.util.endpoints.InternalEndpoint;

public class UserServiceClient extends RestClientTemplate{

	private static final long serialVersionUID = -5477998302135844540L;

	public User get(final Long id) {
		return getTemplate().getForObject(
				InternalEndpoint.PERSISTENCE.getEndpointAddress().append("user/{id}").toString(), User.class, id);
	}

	public void save(final User user) {
		getTemplate().put(InternalEndpoint.PERSISTENCE.getEndpointAddress().append("user").toString(), user);
	}

	public User authenticate(final AuthenticationDTO authenticationDTO){
		return getTemplate().postForObject(
				InternalEndpoint.PERSISTENCE.getEndpointAddress().append("user/authenticate").toString(),
				authenticationDTO, User.class);
	}


}
