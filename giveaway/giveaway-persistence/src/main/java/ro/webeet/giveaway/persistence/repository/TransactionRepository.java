package ro.webeet.giveaway.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import ro.webeet.giveaway.persistence.model.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

}
