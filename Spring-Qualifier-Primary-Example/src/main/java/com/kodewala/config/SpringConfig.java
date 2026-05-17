package com.kodewala.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

import com.kodewala.bean.Account;
import com.kodewala.bean.Company;
import com.kodewala.bean.Employee;

@Configuration
@ComponentScan(basePackages = "com.kodewala")
public class SpringConfig {
	
	@Bean("acc1")
	@Primary
	public Company createCompany() {
		return new Company("Volvo", 2);
	}
	@Bean("acc2")
	public Company createCompanyReports() {
		return new Company("VolvoReport", 2);
	}
	@Bean
	@Lazy //Bean will be created when it is requested first time.
	public Account createAccount() {
		return new Account("Santhosh", "Current Account");
	}
	
	@Bean
	public Employee createEmployeeData() {
		return new Employee("Santhosh", 222);
	}

}
