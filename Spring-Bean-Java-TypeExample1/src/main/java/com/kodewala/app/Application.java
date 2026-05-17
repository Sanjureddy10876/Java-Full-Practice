package com.kodewala.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kodewala.AccountInfo;
import com.kodewala.config.SpringConfig;

public class Application {
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		
		AccountInfo accountInfo = (AccountInfo) context.getBean("acc");
		accountInfo.getAccountId();
		accountInfo.getName();
		accountInfo.getAccountType();
		
		System.out.println("Account ID :"+accountInfo.getAccountId()+" Account Holder Name :"+accountInfo.getName()+"account Type :"+accountInfo.getAccountType());
	}

}
