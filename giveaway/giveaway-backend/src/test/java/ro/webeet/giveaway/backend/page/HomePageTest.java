/**
 *
 */
package ro.webeet.giveaway.backend.page;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

import ro.webeet.giveaway.backend.HomePage;
import ro.webeet.giveaway.backend.WicketApplication;

/**
 * @author webeet
 *
 */
public class HomePageTest {

	private WicketTester tester;

	@Before
	public void setUp() {
		tester = new WicketTester(new WicketApplication());
	}

	@Test
	public void testRenderHomePage() {
		// start and render the test page
		tester.startPage(HomePage.class);
		// assert rendered page class
		tester.assertRenderedPage(HomePage.class);

		tester.startPage(HomePage.class, new PageParameters());
		tester.assertRenderedPage(HomePage.class);
	}

}