/**
 *
 */
package ro.webeet.giveaway.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author webeet
 *
 */
@Entity
@Table(name = "User")
public class User extends DBModel {

	/**
	 *
	 */
	private static final long serialVersionUID = 5945554289741124978L;

	@Id
	@GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
