package com.surshree.app.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ValidationException;
import java.util.Date;
import java.util.NoSuchElementException;

@ControllerAdvice
@RestController
@Slf4j
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
        ExceptionMessage msg = new ExceptionMessage(new Date(), ex.getMessage(), request.getDescription(false));
        log.error(ex.getMessage(), ex);
        return new ResponseEntity(msg, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public final ResponseEntity<Object> handleUsernameNotFoundException(UsernameNotFoundException ex, WebRequest request) throws Exception {
        ExceptionMessage msg = new ExceptionMessage(new Date(), ex.getMessage(), request.getDescription(false));
        log.error(ex.getMessage(), ex);
        return new ResponseEntity(msg, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public final ResponseEntity<Object> handleValidationException(ValidationException ex, WebRequest request) throws Exception {
        ExceptionMessage msg = new ExceptionMessage(new Date(), ex.getMessage(), request.getDescription(false));
        log.error(ex.getMessage(), ex);
        return new ResponseEntity(msg, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public final ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) throws Exception {
        String exMsg = "Value " + NestedExceptionUtils.getMostSpecificCause(ex).getMessage().split("=")[1];
        ExceptionMessage msg = new ExceptionMessage(new Date(), exMsg, request.getDescription(false));
        log.error(ex.getMessage(), ex);
        return new ResponseEntity(msg, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionMessage msg = new ExceptionMessage(new Date(), ex.getMessage(), request.getDescription(false));
        log.error(ex.getMessage(), ex);
        return new ResponseEntity(msg, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionMessage msg = new ExceptionMessage(new Date(), ex.getMessage(), request.getDescription(false));
        log.error(ex.getMessage(), ex);
        return new ResponseEntity(msg, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public final ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex, WebRequest request) throws Exception {
        ExceptionMessage msg = new ExceptionMessage(new Date(), ex.getMessage(), request.getDescription(false));
        log.error("No data present to display.", ex);
        return new ResponseEntity(msg, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuthenticationException.class)
    public final ResponseEntity<Object> handleAuthenticationException(AuthenticationException ex, WebRequest request) throws Exception {
        ExceptionMessage msg = new ExceptionMessage(new Date(), "Login Failed. " + ex.getMessage(), request.getDescription(false));
        log.error("Login Failed.", ex);
        return new ResponseEntity(msg, HttpStatus.NOT_FOUND);
    }
}
