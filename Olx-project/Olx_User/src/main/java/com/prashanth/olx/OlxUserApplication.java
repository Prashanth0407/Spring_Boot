package com.prashanth.olx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class OlxUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxUserApplication.class, args);
	}
	 @Bean
	   public RestTemplate getrestTemplate() {
		   return new RestTemplate();
	    	
	    }
}
