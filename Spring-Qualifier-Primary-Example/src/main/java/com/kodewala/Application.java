package com.kodewala;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kodewala.bean.SpringMgmt;
import com.kodewala.config.SpringConfig;

public class Application {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		SpringMgmt springMgmt = context.getBean(SpringMgmt.class);
		springMgmt.companyData();
		springMgmt.employeeData();	
		springMgmt.bankData();
		
	}
}
