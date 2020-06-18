package com.flipkart.exception;

/**
 * @author ciphereck
 * @category Exception
 *
 */
public class PaymentSucceedRegistrationFailedException extends Exception {

	@Override
	public String getMessage() {
		return "payment succeed. Registration failed.... Your transaction will be reverted";
	}
	
}
