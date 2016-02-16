package ro.webeet.giveaway.persistence.configuration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ro.webeet.giveaway.persistence.environment.ProfileEnvironment;
import ro.webeet.giveaway.persistence.environment.Profiles;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(Profiles.DEVELOPMENT)
@ContextConfiguration(classes = { SpringConfiguration.class })
public class SpringConfigurationTest {

	@Autowired
	private ProfileEnvironment env;

	@Autowired
	private SpringConfiguration config;

	@Test
	public void testShowSelectedEnv() {
		env.dataSource();
		config.showSelectedEnv();
	}

}