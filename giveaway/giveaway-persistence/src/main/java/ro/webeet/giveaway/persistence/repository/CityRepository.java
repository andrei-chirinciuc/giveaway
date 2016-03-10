package ro.webeet.giveaway.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import ro.webeet.giveaway.persistence.model.City;

public interface CityRepository extends CrudRepository<City, Long> {

}
