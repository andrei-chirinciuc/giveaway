package ro.webeet.giveaway.persistence.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import ro.webeet.giveaway.persistence.model.User;

@Configuration
@Import(RepositoryRestMvcConfiguration.class)
public class RestDataConfig extends RepositoryRestMvcConfiguration {

	@Override
	protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		// config.setPageParamName("page").setLimitParamName("limit").setSortParamName("sort");
		config.setBasePath("/data");
		config.exposeIdsFor(User.class);
		config.setDefaultPageSize(20);
		config.setReturnBodyForPutAndPost(true);
		config.setReturnBodyOnCreate(true);
		config.setReturnBodyOnUpdate(true);
	}
}
