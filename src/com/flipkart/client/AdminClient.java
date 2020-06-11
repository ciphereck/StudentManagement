package com.flipkart.client;

import org.apache.log4j.Logger;

public class AdminClient {
	private static final Logger logger = Logger.getLogger(StudentClient.class);
	
	public void showMenu() {
		logger.info("1. Add User");
		logger.info("2. Remove User");
		logger.info("3. Update User");
		logger.info("4. Generate Report Card");
	}
}
