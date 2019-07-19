package com.example.accountService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class AccountDetailsNotFoundException extends Exception {
	public AccountDetailsNotFoundException(String message) {
		super(message);
	}
}
