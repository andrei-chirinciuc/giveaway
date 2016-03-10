package ro.webeet.giveaway.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import ro.webeet.giveaway.persistence.model.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {

}
