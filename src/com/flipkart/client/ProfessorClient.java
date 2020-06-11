package com.flipkart.client;

import org.apache.log4j.Logger;

public class ProfessorClient implements Client {
	private static final Logger logger = Logger.getLogger(StudentClient.class);
	
	public void showMenu() {
		logger.error("Professor Menu");
	}
}
