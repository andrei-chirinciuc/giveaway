package ro.webeet.giveaway.web.filter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.apache.wicket.protocol.http.WicketFilter;

@WebFilter(value = "/*", initParams = {
		@WebInitParam(name = "applicationClassName", value = "ro.webeet.giveaway.web.WicketApplication"),
		@WebInitParam(name = "filterMappingUrlPattern", value = "/*") })
public class GiveawayFilter extends WicketFilter {

}
