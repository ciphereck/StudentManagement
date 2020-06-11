package com.flipkart.client;

import org.apache.log4j.Logger;

public class AdminClient {
	private static final Logger logger = Logger.getLogger(StudentClient.class);
	
	public void showMenu() {
		logger.error("1. Add User");
		logger.error("2. Remove User");
		logger.error("3. Update User");
		logger.error("4. Generate Report Card");
	}
}
