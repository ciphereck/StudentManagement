/**
 * 
 */
package com.flipkart.exception;

/**
 * @author ciphereck
 * @category Exception
 *
 */
public class ProfessorNotTeachingCourseException extends Exception {
	String courseId;
	
	/**
	 * @param courseId
	 */
	public ProfessorNotTeachingCourseException(String courseId) {
		super();
		this.courseId = courseId;
	}



	@Override
	public String getMessage() {
		return "You are not teaching course with courseId: " + courseId;
	}
	
}
