/**
 *
 */
package ro.webeet.giveaway.web;

import org.apache.wicket.Page;
import org.apache.wicket.bean.validation.BeanValidationConfiguration;
import org.apache.wicket.protocol.http.WebApplication;

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
		mountPage("/register", UserRegistrationPage.class);
	}
}
