package ro.webeet.giveaway.rest.dto.user;

import java.util.Date;

import javax.validation.constraints.NotNull;

import ro.webeet.giveaway.persistence.model.property.UserType;
import ro.webeet.giveaway.rest.dto.RestDTO;

public class UserDTO extends RestDTO{

	private static final long serialVersionUID = 1805092000943430799L;
	
	@NotNull(message = "Name must not be null")
	private String name;
	@NotNull(message = "E-mail must not be null")
	private String email;
	@NotNull(message = "Password must not be null")
	private String password;
	private String telephone;
	private Date birthday;
	private Boolean adminFlag;
	private UserType userType;
	
	public UserDTO(){
		
	}

	public UserDTO(String name, String email, String password, String telephone, Date birthday, Boolean adminFlag,
			UserType userType) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		this.birthday = birthday;
		this.adminFlag = adminFlag;
		this.userType = userType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Boolean getAdminFlag() {
		return adminFlag;
	}

	public void setAdminFlag(Boolean adminFlag) {
		this.adminFlag = adminFlag;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
