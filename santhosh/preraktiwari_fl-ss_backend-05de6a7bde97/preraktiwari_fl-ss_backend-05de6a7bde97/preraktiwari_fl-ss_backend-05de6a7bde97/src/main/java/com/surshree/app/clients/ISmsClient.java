package com.surshree.app.clients;

import com.surshree.app.clients.config.FeignClientConfig;
import com.surshree.app.models.sms.OtpValidationRequest;
import com.surshree.app.models.sms.SmsRequestModel;
import com.surshree.app.models.sms.SmsResponseModel;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "sms-service", url="${SMS_SERVICE_SERVICE:http://localhost}:9011", configuration = FeignClientConfig.class)
@RibbonClient(name = "sms-service")
public interface ISmsClient {

    @PostMapping("sms-service/send")
    public SmsResponseModel sendOtp(@RequestBody SmsRequestModel requestModel);

    @PostMapping("sms-service/validate")
    public SmsResponseModel validateOtp(@RequestBody OtpValidationRequest requestModel);
}
