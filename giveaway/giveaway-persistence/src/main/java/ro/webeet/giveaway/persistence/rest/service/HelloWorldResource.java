package ro.webeet.giveaway.persistence.rest.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

	// @Autowired
	// private UserService service;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String getHello() {
		return "hello";
		// return String.valueOf(service.count());
	}
}

