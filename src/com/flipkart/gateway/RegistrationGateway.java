package com.flipkart.gateway;

public class RegistrationGateway {
	public String register(String username, int amount) {
		return username + System.currentTimeMillis() + amount;
	}
}
