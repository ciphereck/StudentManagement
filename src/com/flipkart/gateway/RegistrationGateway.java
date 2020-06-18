package com.flipkart.gateway;

/**
 * @author ciphereck
 * @category Dummy Gateway
 *
 */
public class RegistrationGateway {
	public String register(String username, int amount) {
		return username + System.currentTimeMillis() + amount;
	}
}
