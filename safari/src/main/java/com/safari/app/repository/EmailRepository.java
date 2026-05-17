package com.safari.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.safari.app.entity.EmailEntity;
import com.safari.app.request.EmailRequest;

@Repository
public interface EmailRepository extends JpaRepository<EmailEntity, Long> {

	void save(EmailRequest emailRequest2);

}
