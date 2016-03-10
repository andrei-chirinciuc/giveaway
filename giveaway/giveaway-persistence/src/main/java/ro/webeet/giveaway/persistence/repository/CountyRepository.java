package ro.webeet.giveaway.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import ro.webeet.giveaway.persistence.model.County;

public interface CountyRepository extends CrudRepository<County, Long> {

}
