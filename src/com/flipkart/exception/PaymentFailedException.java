package com.flipkart.exception;

public class PaymentFailedException extends Exception {

	@Override
	public String getMessage() {
		return "Payment failed.....No Money will deduct from your account";
	}
	
}
