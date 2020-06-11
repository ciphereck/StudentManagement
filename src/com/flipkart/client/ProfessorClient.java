package com.flipkart.client;

import org.apache.log4j.Logger;

public class ProfessorClient implements SubClient {
	private static final Logger logger = Logger.getLogger(StudentClient.class);
	
	public void showMenu() {
		logger.info("1. Record Grades");
		logger.info("2. View Course Info");
		logger.info("3. Select Course to Teach");
		logger.info("4. View Catalogue");
	}
}
