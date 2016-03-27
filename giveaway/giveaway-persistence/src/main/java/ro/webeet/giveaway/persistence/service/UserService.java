package ro.webeet.giveaway.persistence.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.webeet.giveaway.persistence.model.User;
import ro.webeet.giveaway.persistence.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public long count() {
		return userRepository.count();
	}

	public List<User> findAll() {
		final List<User> target = new ArrayList<>();
		userRepository.findAll().forEach(target::add);
		return target;
	}

}
