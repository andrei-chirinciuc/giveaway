/**
 *
 */
package ro.webeet.giveaway.persistence.environment;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author webeet
 *
 */
@Configuration
@Profile(Profiles.DEVELOPMENT)
public class DevEnvironment implements ProfileEnvironment {

	private static final Logger log = LoggerFactory.getLogger(DevEnvironment.class);

	@Bean
	public DataSource dataSource() {
		log.debug("DevEnvironment::Running in development mode");
		return null;
	}

}
