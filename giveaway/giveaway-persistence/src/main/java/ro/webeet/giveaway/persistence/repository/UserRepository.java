package ro.webeet.giveaway.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.webeet.giveaway.persistence.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
