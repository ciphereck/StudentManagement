package com.flipkart.exception;

/**
 * @author ciphereck
 * @category Exception
 *
 */
public class BadCredentialException extends Exception {
	@Override
	public String getMessage() {
		return "Wrong username/ password";
	}
	
}
