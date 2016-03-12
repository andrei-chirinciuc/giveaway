package ro.webeet.giveaway.backend.filter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WicketFilter;

/**
 * Defines the main class to be executed.
 *
 * @author webeet
 *
 */
@WebFilter(value = "/*", initParams = {
		@WebInitParam(name = "applicationClassName", value = "ro.webeet.giveaway.backend.WicketApplication"),
		@WebInitParam(name = "filterMappingUrlPattern", value = "/*") })
public class GiveawayFilter extends WicketFilter {

	public GiveawayFilter() {
		super();
	}

	/**
	 * Used by wicket to lunch the main class
	 * 
	 * @param application
	 */
	public GiveawayFilter(WebApplication application) {
		super(application);
	}

}
