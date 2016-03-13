/**
 *
 */
package ro.webeet.giveaway.backend.core;

import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.bean.validation.BeanValidationConfiguration;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;

import ro.webeet.giveaway.backend.page.HomePage;
import ro.webeet.giveaway.backend.page.LoginPage;
import ro.webeet.giveaway.backend.page.SearchUserPage;

/**
 * @author webeet
 *
 */
public class WicketApplication extends AuthenticatedWebApplication {

	@Override
	public Class<? extends Page> getHomePage() {
		return HomePage.class;
	}

	@Override
	protected void init() {
		super.init();

		new BeanValidationConfiguration().configure(this);
		mountPages();
	}

	private void mountPages(){
		this.mountPage("login", LoginPage.class);
		this.mountPage("home", HomePage.class);
		this.mountPage("search/user", SearchUserPage.class);
	}

	@Override
	public final Session newSession(Request request, Response response) {
		return new WebeetSession(request);
	}

	@Override
	protected Class<? extends WebPage> getSignInPageClass() {
		return LoginPage.class;
	}

	@Override
	protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
		return WebeetSession.class;
	}

}
