package com.flipkart.client;

import org.apache.log4j.Logger;

public class StudentClient {
	private static final Logger logger = Logger.getLogger(StudentClient.class);
	
	public void showMenu() {
		logger.info("1. View Catalogue");
		logger.info("2. Add Course");
		logger.info("3. Drop Course");
		logger.info("4. View Report Card");
		logger.info("5. Pay Fee");
	}
}
