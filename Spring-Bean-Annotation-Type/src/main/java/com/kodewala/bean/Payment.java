package com.kodewala.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Payment {

	@Value("13000")
	private int amount;
	@Value("1527")
	private String paymentId;
	@Value("PAID")
	private String status;
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getStatus() {
		return status;
	} 
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void totalPaymentInvoiceDetails() {
		System.out.println("amount : "+amount+""+"paymentId :"+paymentId+"status :"+status);
		
	}
}
