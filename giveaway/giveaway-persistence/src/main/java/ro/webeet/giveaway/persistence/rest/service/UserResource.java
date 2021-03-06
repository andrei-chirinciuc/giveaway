package ro.webeet.giveaway.persistence.rest.service;

import java.util.List;

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
import ro.webeet.giveaway.persistence.service.UserService;
import ro.webeet.giveaway.rest.dto.user.AuthenticationDTO;
import ro.webeet.giveaway.rest.dto.user.UserDTO;

@RestController
@RequestMapping()
public class UserResource {

	@Autowired
	private UserRepository repository;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers() {
		final List<User> users = userService.findAll();
		return new ResponseEntity<List<User>>(users, users != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		final User user = repository.findOne(id);
		return new ResponseEntity<User>(user, user != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public ResponseEntity<Long> count() {
		return new ResponseEntity<Long>(repository.count(), HttpStatus.OK);
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<User> authenticate(@RequestBody AuthenticationDTO authenticationDto) {
		final User user = repository.findByEmailAndPassword(authenticationDto.getUsername(),
				authenticationDto.getPassword());
		return new ResponseEntity<User>(user, user != null ? HttpStatus.OK : HttpStatus.FORBIDDEN);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<User> save(@RequestBody UserDTO userDto) {
		final User user = new User();
		user.setAdminFlag(userDto.getAdminFlag());
		user.setBirthday(userDto.getBirthday());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setTelephone(userDto.getTelephone());
		user.setUserType(userDto.getUserType());
		repository.save(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<User> delete(@RequestBody User user) {
		try {
			user.setDeletedFlag(true);
			repository.save(user);
			return new ResponseEntity<User>(new User(), HttpStatus.OK);
		} catch (final Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
