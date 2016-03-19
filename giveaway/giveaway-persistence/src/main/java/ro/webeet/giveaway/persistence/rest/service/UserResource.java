package ro.webeet.giveaway.persistence.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ro.webeet.giveaway.persistence.model.User;
import ro.webeet.giveaway.persistence.repository.UserRepository;
import ro.webeet.giveaway.rest.dto.user.AuthenticationDTO;

@RestController
public class UserResource {

	@Autowired
	private UserRepository repository;

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		final User user = repository.findOne(id);
		return new ResponseEntity<User>(user, user != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public ResponseEntity<Long> count() {
		return new ResponseEntity<Long>(repository.count(), HttpStatus.OK);
	}

	@RequestMapping(value = "/user/authenticate", method = RequestMethod.POST)
	public ResponseEntity<User> authenticate(@RequestBody AuthenticationDTO authenticationDto) {
		final User user = repository.findByEmailAndPassword(authenticationDto.getUsername(),
				authenticationDto.getPassword());
		return new ResponseEntity<User>(user, user != null ? HttpStatus.OK : HttpStatus.FORBIDDEN);
	}

	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public ResponseEntity<User> save(@RequestBody User user) {
		repository.save(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		try {
			repository.delete(id);
			return ResponseEntity.noContent().build();
		} catch (final Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}
