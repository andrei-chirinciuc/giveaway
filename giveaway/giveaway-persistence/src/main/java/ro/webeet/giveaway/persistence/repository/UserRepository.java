package ro.webeet.giveaway.persistence.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import ro.webeet.giveaway.persistence.model.User;

public interface UserRepository extends CrudRepository<User, Long>, JpaSpecificationExecutor<User> {

}
