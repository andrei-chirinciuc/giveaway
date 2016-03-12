package ro.webeet.giveaway.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reward extends DBModel{

	private static final long serialVersionUID = -3215940559508036586L;

	@Id
	@GeneratedValue
	private Long id;
	private Integer thresholdValue;
	private String description;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getThresholdValue() {
		return thresholdValue;
	}
	public void setThresholdValue(Integer thresholdValue) {
		this.thresholdValue = thresholdValue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
