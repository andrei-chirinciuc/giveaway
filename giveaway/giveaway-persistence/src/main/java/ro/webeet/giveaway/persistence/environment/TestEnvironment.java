package ro.webeet.giveaway.persistence.environment;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(Profiles.TEST)
public class TestEnvironment implements ProfileEnvironment {

	private static final Logger log = LoggerFactory.getLogger(TestEnvironment.class);

	@Bean
	public DataSource dataSource() {
		log.debug("TestEnvironment::Running in test mode");
		return null;
	}

}
