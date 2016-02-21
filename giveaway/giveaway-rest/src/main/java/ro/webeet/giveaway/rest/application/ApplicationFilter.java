package ro.webeet.giveaway.rest.application;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.springframework.test.context.ContextConfiguration;

import ro.webeet.giveaway.persistence.configuration.SpringConfiguration;

@ApplicationPath("/api")
@ContextConfiguration(classes = { SpringConfiguration.class })
public class ApplicationFilter extends Application {

}
