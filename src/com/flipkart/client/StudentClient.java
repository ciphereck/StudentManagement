package com.flipkart.client;

import org.apache.log4j.Logger;

public class StudentClient {
	private static final Logger logger = Logger.getLogger(StudentClient.class);
	
	public void showMenu() {
		logger.error("1. View Catalogue");
		logger.error("2. Add Course");
		logger.error("3. Drop Course");
		logger.error("4. View Report Card");
		logger.error("5. Pay Fee");
	}
}
