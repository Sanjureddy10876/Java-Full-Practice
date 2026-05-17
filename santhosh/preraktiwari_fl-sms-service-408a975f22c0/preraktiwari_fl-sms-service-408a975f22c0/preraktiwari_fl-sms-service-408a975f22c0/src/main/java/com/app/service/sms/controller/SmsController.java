package com.app.service.sms.controller;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.sms.model.OtpValidationRequest;
import com.app.service.sms.model.SmsRequestModel;
import com.app.service.sms.model.SmsResponseModel;
import com.app.service.sms.service.SmsService;

@RestController
public class SmsController {
	
	private final String defaultMessage = "OTP for Garbhotsav Vigyan app is %s. Please do not share this OTP with anyone.";
	
	@Autowired
	private SmsService smsService;
	
	@PostMapping("send")
	public ResponseEntity sendOtp(@RequestBody SmsRequestModel request) {
		int otp;
		System.err.println(":::::::::::::"+"OTP:OTP"+request.getAppName()+","+request.getOtpLength()+","+request.getMobileNo()+","+request.getCountryCode()+","+request.getMessage()+":::::::::::::::::::");

		if(Objects.isNull(request.getOtpLength())) {
			otp = this.smsService.generateOTP(this.getKey(request));
		} else {
			otp = this.smsService.generateOTP(this.getKey(request), Integer.parseInt(request.getOtpLength()));
		}

		System.err.println(":::::::::::::"+"OTP:OTP"+otp+":::::::::::::::::::");
		SmsResponseModel responseModel = new SmsResponseModel();
		responseModel.setIsSuccess(true);
		responseModel.setMessage("Sms Sent Successfully --> " + otp);
		responseModel.setOtp(otp + "");
		String msg = Optional.ofNullable(request.getMessage()).orElse(defaultMessage);
//		this.smsService.sendSms(String.format(msg, otp + ""), this.getPhoneWithCountry(request));
		return ResponseEntity.ok(responseModel);
	}
	
	public String getPhoneWithCountry(SmsRequestModel request) {
		if(Objects.nonNull(request.getCountryCode())) {
			return String.join("", request.getCountryCode(), request.getMobileNo());
		}else {
			return String.join("", "+91", request.getMobileNo());
		}
	}
	
	@PostMapping("validate")
	public ResponseEntity validateOtp(@RequestBody OtpValidationRequest request) {
		String key = this.getKey(request);
		boolean isSuccess = this.smsService.validateOtp(key, request.getOtp());
		SmsResponseModel responseModel = new SmsResponseModel();
		responseModel.setIsSuccess(isSuccess);
		if(isSuccess) {
			responseModel.setMessage("OTP Verification Successful.");
			//this.smsService.clearOTP(key);
		} else {
			responseModel.setMessage("OTP Verification Failed.");
		}
		return ResponseEntity.ok(responseModel);
	}
	
	private String getKey(SmsRequestModel request) {
		return String.join("_", request.getAppName().trim(), request.getMobileNo());
	}
	
	private String getKey(OtpValidationRequest request) {
		return String.join("_", request.getAppName().trim(), request.getMobileNo());
	}

}
