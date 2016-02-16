package ro.webeet.giveaway.persistence.environment;

import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Profile(Profiles.TEST)
@PropertySources({ @PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = false), })
public class TestEnvironment implements ProfileEnvironment {

	private static final Logger log = LoggerFactory.getLogger(TestEnvironment.class);

	@Autowired
	private Environment env;

	@Override
	@Bean
	public DataSource dataSource() {
		log.debug("TestEnvironment::Running in test mode");
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
		dataSource.setUrl(env.getRequiredProperty("db.url"));
		dataSource.setUsername(env.getRequiredProperty("db.username"));
		dataSource.setPassword(env.getRequiredProperty("db.password"));
		return dataSource;
	}

	@Override
	public Properties getHibernateProperties() {
		final Properties properties = new Properties();
		properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
		properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
		properties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));
		properties.put(PROPERTY_NAME_HIBERNATE_NAMING, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_NAMING));
		properties.put(PROPERTY_NAME_HIBERNATE_DDL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DDL));
		return properties;
	}

}
