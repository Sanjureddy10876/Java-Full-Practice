package com.surshree.app.models.sms;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OtpValidationRequest {

	private String appName;
	
	private String mobileNo;
	
	private String otp;
}
