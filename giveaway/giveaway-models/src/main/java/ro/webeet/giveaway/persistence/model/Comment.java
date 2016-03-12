package ro.webeet.giveaway.persistence.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import ro.webeet.giveaway.persistence.model.property.EntityTemplate;

@Entity
public class Comment extends DBModel{

	private static final long serialVersionUID = -8030829953709113701L;

	@Id
	@GeneratedValue
	private Long id;
	private Boolean publicFlag;
	private Long entityId;

	@ManyToOne
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "USER_ID")
	private User user;

	@OneToMany
	@JoinColumn(name = "COMMENT_ID", nullable = true, unique = false)
	private List<Comment> comment;

	@Enumerated
	private EntityTemplate entity;// the reference entity

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getPublicFlag() {
		return publicFlag;
	}

	public void setPublicFlag(Boolean publicFlag) {
		this.publicFlag = publicFlag;
	}

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public EntityTemplate getEntity() {
		return entity;
	}

	public void setEntity(EntityTemplate entity) {
		this.entity = entity;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

}
