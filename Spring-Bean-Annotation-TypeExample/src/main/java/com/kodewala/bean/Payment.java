package com.kodewala.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Payment {
	
	@Value("22332")
	private int paymentId;
	@Value("PhonePay")
	private String paymentMenthod;
	@Value("Completed")
	private String status;
	
	
	
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentMenthod() {
		return paymentMenthod;
	}
	public void setPaymentMenthod(String paymentMenthod) {
		this.paymentMenthod = paymentMenthod;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	public void paymentCompleted() {
		System.out.println("Payment ID :"+paymentId+"Payment Medthod :"+paymentMenthod+"Status :"+status);
	}
}
