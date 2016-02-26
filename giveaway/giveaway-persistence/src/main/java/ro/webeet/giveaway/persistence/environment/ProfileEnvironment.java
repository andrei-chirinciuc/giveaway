package ro.webeet.giveaway.persistence.environment;

import java.util.Properties;

import javax.sql.DataSource;

import ro.webeet.giveaway.util.exception.DatasourceException;

public abstract class ProfileEnvironment {

	static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	static final String PROPERTY_NAME_HIBERNATE_DDL = "hibernate.hbm2ddl.auto";
	static final String PROPERTY_NAME_HIBERNATE_NAMING = "hibernate.ejb.naming_strategy";
	static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";

	public abstract DataSource dataSource() throws DatasourceException;

	public abstract Properties getHibernateProperties();

}
