package com.flipkart.exception;

public class BadCredentialException extends Exception {
	@Override
	public String getMessage() {
		return "Wrong username/ password";
	}
	
}
