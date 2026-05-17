package com.kodewala.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.kodewala.bean.Company;
import com.kodewala.bean.Vehicle;

@Configuration
@ComponentScan(basePackages = "com.kodewala")
public class SpringConfig {
	
	@Bean("acc1")

	public Company createDeatils1() {
		return new Company("Ford 1 ","This is Ford 1 Comapny");
	}
	@Bean("acc2")
	public Company createDeatils2() {
		return new Company("Ford 2 ","This is Ford 2 Comapny");
	}
	
	@Bean
	public Vehicle vehcleDetails() {
		return new Vehicle(2, "Maruthi", "TwinLiter2.2L");
	}
	

}
