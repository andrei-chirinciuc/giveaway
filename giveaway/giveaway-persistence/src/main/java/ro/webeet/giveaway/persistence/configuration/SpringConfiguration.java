/**
 *
 */
package ro.webeet.giveaway.persistence.configuration;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import ro.webeet.giveaway.persistence.environment.ProfileEnvironment;
import ro.webeet.giveaway.util.exception.DatasourceException;

/**
 * @author webeet
 *
 */
@Configuration
@EnableWebMvc
@EnableJpaRepositories(basePackages = { "ro.webeet.giveaway.persistence.repository" })
@EnableHypermediaSupport(type = { HypermediaType.HAL })
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = false)
@ComponentScan(basePackages = { "ro.webeet.giveaway.persistence.service", "ro.webeet.giveaway.persistence.model",
		"ro.webeet.giveaway.persistence.rest.service", "ro.webeet.giveaway.persistence.environment" })
public class SpringConfiguration extends RestDataConfig {

	@Autowired
	private ProfileEnvironment profile;

	public DataSource dataSource() throws DatasourceException {
		return profile.dataSource();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws DatasourceException {
		final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setPackagesToScan("ro.webeet.giveaway.persistence.model");
		entityManagerFactoryBean.setJpaProperties(profile.getHibernateProperties());
		return entityManagerFactoryBean;
	}

	@Bean
	public JpaTransactionManager transactionManager() throws DatasourceException {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}



}
