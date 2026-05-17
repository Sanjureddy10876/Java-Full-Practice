package com.safari.app.service;

import com.safari.app.request.EmailRequest;

public interface EmailService {

	void doMail(EmailRequest emailRequest);
}
