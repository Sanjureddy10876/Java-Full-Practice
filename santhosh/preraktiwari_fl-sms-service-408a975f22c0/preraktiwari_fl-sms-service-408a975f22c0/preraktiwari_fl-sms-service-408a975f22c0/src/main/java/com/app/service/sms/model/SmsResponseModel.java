package com.app.service.sms.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SmsResponseModel {
	
	private String message;
	
	private Boolean isSuccess;
	
	private String otp;
}
