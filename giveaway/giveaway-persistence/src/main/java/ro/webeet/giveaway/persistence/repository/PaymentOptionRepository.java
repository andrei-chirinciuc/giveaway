package ro.webeet.giveaway.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import ro.webeet.giveaway.persistence.model.PaymentOption;

public interface PaymentOptionRepository extends CrudRepository<PaymentOption, Long> {

}
