package com.kodewala.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kodewala.AccountInfo;

@Configuration //this class is responsible for bean definition
public class SpringConfig {
	
	//here beans
	
	@Bean("acc")
	public AccountInfo createdAccount() {
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.setAccountType("Savings");
		accountInfo.setName("Santhosh");	
		return accountInfo;
	}
	
	@Bean("acc1")
	public AccountInfo createAccount1() {
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.setAccountType("CURRENT");
		accountInfo.setName("Reddy");
		return accountInfo;
	}

}
