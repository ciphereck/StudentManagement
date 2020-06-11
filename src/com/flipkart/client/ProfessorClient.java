package com.flipkart.client;

import org.apache.log4j.Logger;

public class ProfessorClient {
	private static final Logger logger = Logger.getLogger(StudentClient.class);
	
	public void showMenu() {
		logger.error("1. Record Grades");
		logger.error("2. View Course Info");
		logger.error("3. Select Course to Teach");
		logger.error("4. View Catalogue");
	}
}
