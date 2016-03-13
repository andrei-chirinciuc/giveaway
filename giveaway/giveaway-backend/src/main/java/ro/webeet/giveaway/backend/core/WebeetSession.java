package ro.webeet.giveaway.backend.core;

import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

import ro.webeet.giveaway.persistence.model.User;

public class WebeetSession extends AuthenticatedWebSession {

	private static final long serialVersionUID = -7034087369555509328L;

	private User user;

	public WebeetSession(Request request) {
		super(request);
	}

	public static WebeetSession get() {
		return (WebeetSession) Session.get();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		signIn(user.getEmail(), user.getPassword());
	}

	public void logout() {
		setUser(null);
		invalidate();
	}

	@Override
	protected boolean authenticate(String username, String password) {
		return user != null && username.equalsIgnoreCase(user.getEmail())
				&& password.equalsIgnoreCase(user.getPassword());
	}

	@Override
	public Roles getRoles() {
		// TODO Auto-generated method stub
		return null;
	}

}
