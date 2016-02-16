/**
 *
 */
package ro.webeet.giveaway.persistence.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import ro.webeet.giveaway.persistence.environment.ProfileEnvironment;

/**
 * @author webeet
 *
 */
@Configuration
@PropertySources({ @PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = false), })
@ComponentScan({ "ro.webeet.giveaway.persistence" })
public class SpringConfiguration {

	@Autowired
	private ProfileEnvironment profile;

	public void showSelectedEnv() {
		profile.dataSource();
	}


}
