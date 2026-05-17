package com.dell.kode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	

	 @ExceptionHandler(UserNotFoundException.class)
	    public ResponseEntity<String> handleProductException(UserNotFoundException ex) {

	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }


}
