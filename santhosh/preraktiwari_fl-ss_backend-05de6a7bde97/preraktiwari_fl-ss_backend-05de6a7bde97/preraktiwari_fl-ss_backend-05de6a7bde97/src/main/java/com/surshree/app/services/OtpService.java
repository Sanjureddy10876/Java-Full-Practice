package com.surshree.app.services;


import com.surshree.app.clients.ISmsClient;
import com.surshree.app.models.sms.OtpValidationRequest;
import com.surshree.app.models.sms.SmsRequestModel;
import com.surshree.app.models.sms.SmsResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OtpService {

    @Autowired
    private ISmsClient smsClient;

    public String generateOTP(String key){
        SmsRequestModel requestModel = new SmsRequestModel();
        requestModel.setAppName("SSAPP");
        requestModel.setOtpLength("6");
        requestModel.setMobileNo(key);
        requestModel.setMessage("OTP for Surshree application is %s. Please do not share this OTP with anyone.");
        SmsResponseModel responseModel = this.smsClient.sendOtp(requestModel);
        return responseModel.getOtp();
    }

    public boolean validateOtp(String key, String otp){
        OtpValidationRequest validationRequest = new OtpValidationRequest();
        validationRequest.setAppName("SSAPP");
        validationRequest.setMobileNo(key);
        validationRequest.setOtp(otp);
        SmsResponseModel responseModel = this.smsClient.validateOtp(validationRequest);
        return responseModel.getIsSuccess();
    }
}
