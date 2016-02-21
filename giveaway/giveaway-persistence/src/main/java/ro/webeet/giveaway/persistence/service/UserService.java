package ro.webeet.giveaway.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.webeet.giveaway.persistence.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public long count() {
		return userRepository.count();
	}

}
