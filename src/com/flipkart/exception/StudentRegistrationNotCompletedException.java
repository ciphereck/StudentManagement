package com.flipkart.exception;

/**
 * @author ciphereck
 * @category Exception
 *
 */
public class StudentRegistrationNotCompletedException extends Exception {
	String studentUsername;

	/**
	 * @param studentUsername
	 */
	public StudentRegistrationNotCompletedException(String studentUsername) {
		super();
		this.studentUsername = studentUsername;
	}

	@Override
	public String getMessage() {
		return studentUsername + " didn't completed registration";
	}
	
	
}
