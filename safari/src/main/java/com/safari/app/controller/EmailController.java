package com.safari.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safari.app.request.EmailRequest;
import com.safari.app.response.EmailResponse;
import com.safari.app.service.EmailService;

@RestController
@RequestMapping("/api/mail/")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/doLoginMail")
	public ResponseEntity<EmailResponse> doMail(@RequestBody EmailRequest emailRequest){
		
		emailService.doMail(emailRequest);
		
		EmailResponse emailResponse = new EmailResponse();
		emailResponse.setStatus(null);
		emailResponse.setMessage("Login Sucess Through Mail");
		
		
		return ResponseEntity.ok(emailResponse);
	}

}
