package com.flipkart.client;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;

public interface SubClient {
	static final Logger subClientLogger = Logger.getLogger(SubClient.class);
	
	public void showMenu();
	default public void showCurrentTime(boolean login, String type) { // 1 for login and 0 for logout
		LocalDateTime localDateTime = LocalDateTime.now();
		String message = type + " Logged " + (login==true? "In" : "Out") + " at: " + localDateTime;
		subClientLogger.info(message);
	}
}
