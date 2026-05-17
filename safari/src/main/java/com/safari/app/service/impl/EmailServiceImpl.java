package com.safari.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safari.app.repository.EmailRepository;
import com.safari.app.request.EmailRequest;
import com.safari.app.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	private EmailRepository emailRepository;
	

	@Override
	public void doMail(EmailRequest emailRequest) {
		
		
		EmailRequest emailRequest2 = new EmailRequest();
		emailRequest2.setMail(emailRequest.getMail());
		emailRequest2.setPassword(emailRequest.getPassword());
		emailRepository.save(emailRequest2);
		
		if (emailRequest2!=null) {
			System.out.println();
		}
		
	}

}
