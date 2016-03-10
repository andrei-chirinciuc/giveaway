package ro.webeet.giveaway.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import ro.webeet.giveaway.persistence.model.Reward;

public interface RewardRepository extends CrudRepository<Reward, Long> {

}
