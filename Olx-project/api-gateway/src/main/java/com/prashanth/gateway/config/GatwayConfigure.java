package com.prashanth.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatwayConfigure {

	   @Autowired
	  AuthenticationFilter filter;
	
      @Bean	
	   public RouteLocator routes(RouteLocatorBuilder builder) {
		   return builder.routes() 
				   .route("olx-advertises", r -> r.path("/advertise/**")
				   .filters(f -> f.filter(filter)).uri("lb://olx-advertises/"))
				   .route("olx-masterdata",r ->r.path("/advertise/**")
						   .filters(f ->f.filter(filter)).uri("lb://olx-masterdata/**"))
				   .route("olx-users" ,r ->r.path("/user/**")
						  .filters(f -> f.filter(filter))
						  .uri("lb://olx-users/"))
				  .build();
				  
						 
	   }
}
