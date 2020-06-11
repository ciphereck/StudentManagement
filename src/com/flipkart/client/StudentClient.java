package com.flipkart.client;

import org.apache.log4j.Logger;

public class StudentClient implements Client {
	private static final Logger logger = Logger.getLogger(StudentClient.class);
	
	public void showMenu() {
		logger.error("1. Add Course");
		logger.error("2. View Course");
		logger.error("3. Drop Course");
		logger.error("Student Menu");
	}
}
