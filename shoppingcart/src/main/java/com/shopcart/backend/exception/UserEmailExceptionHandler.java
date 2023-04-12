package com.shopcart.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserEmailExceptionHandler {

	@ExceptionHandler(value= {UserEmailNotFoundException.class})
	public ResponseEntity<Object> handleUserEmailNotFoundException
	(UserEmailNotFoundException userEmailNotFoundException){
		
		UserEmailException userEmailException = new UserEmailException
				(userEmailNotFoundException.getMessage(),userEmailNotFoundException.getCause(),HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(userEmailException,HttpStatus.NOT_FOUND);
		
	}
}
