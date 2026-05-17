package com.kodewala.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.kodewala.pojo.Address;
import com.kodewala.pojo.Employe;

@Configuration
@ComponentScan(basePackages = "com.kodewala")
public class SpringConfig {

	@Bean
	public Address createAddress() {
		
		return new Address("Hyderabad", "Telengana");
	}
	
	@Bean
	public Employe creatEmploye() {
		
		return new Employe(createAddress());
	}

}
