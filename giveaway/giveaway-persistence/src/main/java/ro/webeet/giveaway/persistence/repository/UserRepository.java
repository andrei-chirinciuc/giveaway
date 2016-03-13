package ro.webeet.giveaway.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import ro.webeet.giveaway.persistence.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

	User findByEmailAndPassword(String username, String password);

}
