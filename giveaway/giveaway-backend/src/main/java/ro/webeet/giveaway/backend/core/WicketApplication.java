/**
 *
 */
package ro.webeet.giveaway.backend.core;

import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.bean.validation.BeanValidationConfiguration;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;

import ro.webeet.giveaway.backend.page.HomePage;
import ro.webeet.giveaway.backend.page.LoginPage;

/**
 * @author webeet
 *
 */
public class WicketApplication extends WebApplication {

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
	}

	@Override
	public final Session newSession(Request request, Response response) {
		return new WebeetSession(request);
	}

}
