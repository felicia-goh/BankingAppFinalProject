package com.softra.banking;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BankingAppFinalProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BankingAppFinalProjectApplication.class, args);
		RestTemplate template = context.getBean("resttemplate", RestTemplate.class);
		
		String result = consumeGetRestApis(template);
		System.out.println("response received after invoking get");
	}
	
	public static String consumeGetRestApis(RestTemplate resttemplate) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity <String> entity = new HttpEntity<String>(headers);
		String url = "http://localhost:9090/";
		String result = resttemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
		return result;
	}
	
	public static String consumePostRestApis(RestTemplate resttemplate, User user) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity <String> entity = new HttpEntity<String>(headers);
		String url = "http://localhost:9090/users";
		String result = resttemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();
		return result;
	}
	
	@Bean(name="resttemplate")
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
