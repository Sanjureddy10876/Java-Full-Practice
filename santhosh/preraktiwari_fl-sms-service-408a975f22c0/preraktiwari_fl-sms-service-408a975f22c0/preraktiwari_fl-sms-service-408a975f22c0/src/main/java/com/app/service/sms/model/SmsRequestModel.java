package com.app.service.sms.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SmsRequestModel {
	
	private String appName;
	
	private String countryCode;
	
	private String mobileNo;
	
	private String otpLength;
	
	private String message;
	
}
