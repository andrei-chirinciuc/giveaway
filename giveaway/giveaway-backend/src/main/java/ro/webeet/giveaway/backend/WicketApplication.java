/**
 *
 */
package ro.webeet.giveaway.backend;

import org.apache.wicket.Page;
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

}
