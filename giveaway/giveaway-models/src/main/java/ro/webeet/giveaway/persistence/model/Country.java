package ro.webeet.giveaway.persistence.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Country extends DBModel{

	private static final long serialVersionUID = -578107695820708323L;

	@Id
	@GeneratedValue
	private Long id;
	private String isoCode;

	@OneToMany(mappedBy = "country")
	private Set<County> counties;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	public Set<County> getCounties() {
		return counties == null ? counties = new HashSet<County>() : counties;
	}

	public void setCounties(Set<County> counties) {
		this.counties = counties;
	}

}
