package com.kodewala.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kodewala.AccountInfo;

@Configuration
public class SpringConfig {
	
	
	@Bean("acc")
	public AccountInfo createAccount() {
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.setAccountId(11);
		accountInfo.setName("Santhosh Reddy");
		accountInfo.setAccountType("CURRENT");
		return accountInfo;
	}

}
