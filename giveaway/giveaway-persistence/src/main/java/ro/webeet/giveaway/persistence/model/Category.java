package ro.webeet.giveaway.persistence.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Category extends DBModel{

	private static final long serialVersionUID = -1673648983622889803L;

	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
	@JoinColumn(name = "CATEGORY_ID", nullable = true, unique = false)
	private List<Category> category;
	private String name;
	private String description;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
