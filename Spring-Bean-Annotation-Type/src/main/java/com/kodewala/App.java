package com.kodewala;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kodewala.bean.Payment;
import com.kodewala.config.Springconfig;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Springconfig.class);
		
		Payment payment = context.getBean(Payment.class);
		payment.totalPaymentInvoiceDetails();
	}

}
