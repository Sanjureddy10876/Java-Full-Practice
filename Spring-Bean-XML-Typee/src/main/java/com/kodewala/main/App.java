package com.kodewala.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kodewala.account.Account;

public class App {

	public static void main(String[] args) {
		
		String config = "applicationContext.xml";
		
		//Create IOC container(Bean Factory / ApplicationContext)
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		
		//Requesting /getting bean from container.
		Account account = (Account) context.getBean("acc");
		//Using the account bean
		System.out.println(account.getFirstName()+" and "+account.getLastName());
	}
}
