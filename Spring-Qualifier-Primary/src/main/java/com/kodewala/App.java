package com.kodewala;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kodewala.bean.CompanyMgmt;
import com.kodewala.config.SpringConfig;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
	
		CompanyMgmt companyMgmt = context.getBean(CompanyMgmt.class);
		companyMgmt.printDetails();
		
		companyMgmt.vehicleDetails();
		
	}

}
