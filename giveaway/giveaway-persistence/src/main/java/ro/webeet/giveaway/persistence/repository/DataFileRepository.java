package ro.webeet.giveaway.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import ro.webeet.giveaway.persistence.model.DataFile;

public interface DataFileRepository extends CrudRepository<DataFile, Long> {

}
