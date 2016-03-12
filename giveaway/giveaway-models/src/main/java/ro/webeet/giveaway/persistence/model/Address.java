package ro.webeet.giveaway.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Address extends DBModel{

	private static final long serialVersionUID = -8811632886524106517L;

	@Id
	@GeneratedValue
	private Long id;
	private String street;

	@ManyToOne
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "CITY_ID")
	private City city;

	@OneToOne(optional = false)
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}

}
