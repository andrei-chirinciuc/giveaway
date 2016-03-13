package ro.webeet.giveaway.rest.dto.user;

import ro.webeet.giveaway.rest.dto.RestDTO;

public class AuthenticationDTO extends RestDTO {

	private static final long serialVersionUID = -5467552548408331784L;

	private String username;
	private String password;

	public AuthenticationDTO() {

	}

	public AuthenticationDTO(final String username, final String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
