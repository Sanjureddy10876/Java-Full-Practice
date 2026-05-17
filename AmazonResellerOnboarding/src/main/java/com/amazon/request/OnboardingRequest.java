package com.amazon.request;

import org.springframework.stereotype.Controller;

@Controller
public class OnboardingRequest {

	String sellerName;
	String SellerMobile;
	String SellerEmail;
	String SellerType;
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerMobile() {
		return SellerMobile;
	}
	public void setSellerMobile(String sellerMobile) {
		SellerMobile = sellerMobile;
	}
	public String getSellerEmail() {
		return SellerEmail;
	}
	public void setSellerEmail(String sellerEmail) {
		SellerEmail = sellerEmail;
	}
	public String getSellerType() {
		return SellerType;
	}
	public void setSellerType(String sellerType) {
		SellerType = sellerType;
	}
	
	
}
