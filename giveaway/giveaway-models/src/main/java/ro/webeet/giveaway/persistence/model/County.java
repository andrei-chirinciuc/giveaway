package ro.webeet.giveaway.persistence.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class County extends DBModel{

	private static final long serialVersionUID = 6038327898600678171L;

	@Id
	@GeneratedValue
	private Long id;
	private String name;

	@ManyToOne
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "COUNTRY_ID")
	private Country country;

	@OneToMany(mappedBy = "county")
	private Set<City> cities;

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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Set<City> getCity() {
		return cities == null ? cities = new HashSet<City>() : cities;
	}

	public void setCity(Set<City> city) {
		cities = city;
	}

}
