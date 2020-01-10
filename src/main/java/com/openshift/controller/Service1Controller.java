package com.openshift.controller;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/service1")
public class Service1Controller {

	@Autowired
	RestTemplate restTemplate;
	
	@Value("${service2.product-url}")
        private String service2_product_url;
	
	
	@GetMapping("/info")
	public String welcome() {
		return "++++++++++++++++++++++++++++  -: Welcome to Service 1 :- +++++++++++++++++++++++++++++++++ ";
	}
	
	@RequestMapping(value = "/getProductsList", method = RequestMethod.GET)	
	public List<Object> getProducts() {	 
		
	ResponseEntity<Object[]> response = restTemplate.getForEntity(service2_product_url, Object[].class);
	return Arrays.asList(response.getBody());
	
	}	
	
}
