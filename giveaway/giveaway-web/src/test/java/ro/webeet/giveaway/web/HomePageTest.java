/**
 *
 */
package ro.webeet.giveaway.web;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

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
	}

}
