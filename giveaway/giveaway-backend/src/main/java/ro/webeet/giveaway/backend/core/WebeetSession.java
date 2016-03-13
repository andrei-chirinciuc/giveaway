package ro.webeet.giveaway.backend.core;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

import ro.webeet.giveaway.persistence.model.User;

public class WebeetSession extends WebSession {

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
	}

	public boolean isLoggedId() {
		return user != null;
	}

	public void signOut() {
		setUser(null);
		invalidateNow();
	}

}
