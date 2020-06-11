package com.flipkart.client;

import org.apache.log4j.Logger;

public class AdminClient implements Client {
	private static final Logger logger = Logger.getLogger(StudentClient.class);
	
	public void showMenu() {
		logger.error("Admin Menu");
	}
}
