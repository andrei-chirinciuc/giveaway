package ro.webeet.giveaway.persistence.rest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ro.webeet.giveaway.persistence.service.UserService;

@RestController
public class HelloWorldResource {
	private final static Logger LOGGER = LoggerFactory.getLogger(HelloWorldResource.class);

	@Autowired
	private UserService service;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String getHello() {
		LOGGER.debug("Hello service called...");
		return String.valueOf(service.count());
	}
}

