package com.openshift;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Service1Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);
	}

	  @Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
	  
	  @Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
			return builder.sources(Service1Application.class);
		}
}
