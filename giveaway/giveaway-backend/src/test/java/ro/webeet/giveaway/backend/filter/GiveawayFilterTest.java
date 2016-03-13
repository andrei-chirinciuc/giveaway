package ro.webeet.giveaway.backend.filter;

import static org.junit.Assert.assertNotNull;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

import ro.webeet.giveaway.backend.core.WicketApplication;
import ro.webeet.giveaway.backend.core.filter.GiveawayFilter;

public class GiveawayFilterTest {

	private WicketTester tester;

	@Before
	public void setUp() {
		tester = new WicketTester(new WicketApplication());
	}

	@Test
	public void testGiveawayFilter() {
		GiveawayFilter filter = new GiveawayFilter();
		assertNotNull(filter);
		filter = new GiveawayFilter(tester.getApplication());
		assertNotNull(filter);
	}

}
