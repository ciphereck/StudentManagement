package com.flipkart.exception;

public class StudentNotFoundException extends Exception {
	String studentUsername;

	/**
	 * @param studentUsername
	 */
	public StudentNotFoundException(String studentUsername) {
		super();
		this.studentUsername = studentUsername;
	}

	@Override
	public String getMessage() {
		return studentUsername + " does not exist";
	}
	
	
}
