package com.surshree.app.models.sms;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SmsRequestModel {
	
	private String appName;
	
	private String mobileNo;
	
	private String otpLength;
	
	private String message;
	
}
