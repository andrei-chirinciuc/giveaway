/**
 *
 */
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
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import ro.webeet.giveaway.util.exception.DatasourceException;

/**
 * @author webeet
 *
 */
@Configuration
@Profile(Profiles.DEVELOPMENT)
@PropertySources({ @PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = false), })
public class DevEnvironment implements ProfileEnvironment {

	private static final Logger log = LoggerFactory.getLogger(DevEnvironment.class);

	@Autowired
	private Environment env;

	@Override
	@Bean(destroyMethod = "close")
	public DataSource dataSource() throws DatasourceException {
		log.debug("DevEnvironment::Initializing database");
		final JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		dataSourceLookup.setResourceRef(true);
		DataSource dataSourceTemp = null;
		try {
			dataSourceTemp = dataSourceLookup.getDataSource(env.getRequiredProperty("giveaway.dev.jndi"));
		} catch (final DataSourceLookupFailureException e) {
			log.error("DataSource not found.");
			throw new DatasourceException(e);
		}
		final HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDataSource(dataSourceTemp);
		return new HikariDataSource(hikariConfig);
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
