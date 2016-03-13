package ro.webeet.giveaway.rest.client;

import java.io.Serializable;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RestClientTemplate implements Serializable{

	private static final long serialVersionUID = -6057770277707457802L;

	private RestTemplate template;
	
	public RestTemplate getTemplate(){
		if(template==null){
			template = new RestTemplate();
			template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		}
		return template;
	}
}
