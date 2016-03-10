package ro.webeet.giveaway.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import ro.webeet.giveaway.persistence.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
