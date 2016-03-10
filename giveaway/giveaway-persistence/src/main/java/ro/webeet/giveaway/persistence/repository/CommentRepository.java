package ro.webeet.giveaway.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import ro.webeet.giveaway.persistence.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
