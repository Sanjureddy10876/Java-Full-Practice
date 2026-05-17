package com.amazon.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amazon.request.OnboardingRequest;

@Controller
public class SellerOnboardingController {
//
//	@RequestMapping("onboarding")
//	@ResponseBody
//	public String doOnboarding(@ModelAttribute OnboardingRequest request) {
//		
//		System.out.println("Request recevied for seller onboarding");
//		System.out.println("Seller Name : "+request.getSellerName());
//		System.out.println("Seller Mobile Number : "+request.getSellerMobile());
//		System.out.println("Seller Email : "+request.getSellerEmail());
//		System.out.println("Seller Type : "+request.getSellerType());
//		
//		return "we have recevied your request. Out team will get in touch with you for next step";
//	}

	@RequestMapping("onboardingpost/{id}")
	@ResponseBody
	public String doOnboardingpost(@ModelAttribute OnboardingRequest request,@PathVariable("id") String id) {
		
		System.out.println("Request recevied for seller onboarding");
		System.out.println("Seller Name : "+request.getSellerName());
		System.out.println("Seller Mobile Number : "+request.getSellerMobile());
		System.out.println("Seller Email : "+request.getSellerEmail());
		System.out.println("Seller Type : "+request.getSellerType());
		System.out.println("id ::"+id);
		
		return "we have recevied your request. Out team will get in touch with you for next step";
	}
	
}
