package ro.webeet.giveaway.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class City extends DBModel{

	private static final long serialVersionUID = 2148151820746926240L;

	@Id
	@GeneratedValue
	private Long id;
	private String name;

	@ManyToOne
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "COUNTY_ID")
	private County county;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public County getCounty() {
		return county;
	}

	public void setCounty(County county) {
		this.county = county;
	}

}
