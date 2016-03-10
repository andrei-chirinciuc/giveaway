package ro.webeet.giveaway.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import ro.webeet.giveaway.persistence.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
