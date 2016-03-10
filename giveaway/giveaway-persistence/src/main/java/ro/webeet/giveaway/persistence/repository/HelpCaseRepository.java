package ro.webeet.giveaway.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import ro.webeet.giveaway.persistence.model.HelpCase;

public interface HelpCaseRepository extends CrudRepository<HelpCase, Long> {

}
