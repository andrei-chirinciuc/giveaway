package ro.webeet.giveaway.persistence.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Controller with a few convenience redirects to expose the HAL browser shipped
 * as static content.
 *
 */
@BasePathAwareController
public class HalBrowser {

	private static String BROWSER = "/browser";
	public static String BROWSER_INDEX = BROWSER.concat("/index.html");

	private final RepositoryRestConfiguration configuration;

	/**
	 * Creates a new {@link HalBrowser} for the given
	 * {@link RepositoryRestConfiguration}.
	 *
	 * @param configuration
	 *            must not be {@literal null}.
	 */
	@Autowired
	public HalBrowser(RepositoryRestConfiguration configuration) {

		Assert.notNull(configuration, "RepositoryRestConfiguration must not be null!");

		this.configuration = configuration;
	}

	/**
	 * Redirects requests to the API root asking for HTML to the HAL browser.
	 *
	 * @return
	 */
	@RequestMapping(value = { "/b", "" }, method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public View index() {
		return browser();
	}

	/**
	 * Redirects to the actual {@code index.html}.
	 *
	 * @return
	 */
	@RequestMapping(value = "/browser", method = RequestMethod.GET)
	public View browser() {

		final String basePath = configuration.getBasePath().toString();
		return new RedirectView(basePath.concat(BROWSER_INDEX).concat("#").concat(basePath), true);
	}
}
