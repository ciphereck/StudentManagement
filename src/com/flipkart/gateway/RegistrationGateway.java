package com.flipkart.gateway;

/**
 * @author ciphereck
 * @category Dummy Gateway
 *
 */
public class RegistrationGateway {
	/**
	 * 
	 * @param username
	 * @param amount
	 * @return Registration Id
	 */
	public String register(String username, int amount) {
		return username + System.currentTimeMillis() + amount;
	}
}
