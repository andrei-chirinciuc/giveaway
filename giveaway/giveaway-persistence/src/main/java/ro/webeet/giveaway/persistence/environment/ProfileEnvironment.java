package ro.webeet.giveaway.persistence.environment;

import javax.sql.DataSource;

import ro.webeet.giveaway.util.exception.DatasourceException;

public interface ProfileEnvironment {

	DataSource dataSource() throws DatasourceException;

}
