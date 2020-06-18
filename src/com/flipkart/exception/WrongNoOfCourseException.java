package com.flipkart.exception;

/**
 * @author ciphereck
 * @category Exception
 *
 */
public class WrongNoOfCourseException extends Exception {
	int totalCourse;

	/**
	 * @param totalCourse
	 */
	public WrongNoOfCourseException(int totalCourse) {
		super();
		this.totalCourse = totalCourse;
	}

	@Override
	public String getMessage() {
		return "Total number of course required = 4, but found: " + totalCourse;
	}
	
	
}
