package com.example.SpringSecurityAuthentication.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.SpringSecurityAuthentication.exceptions.UserNotFoundException;

@ControllerAdvice
public class UserExceptionController {
	@ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> exception(UserNotFoundException exception) {
       return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }

}
