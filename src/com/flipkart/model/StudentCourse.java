package com.flipkart.model;

public class StudentCourse extends Course {
	String studentUsername;
	String timestamp;
	String grade;
	
	/**
	 * 
	 */
	public StudentCourse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the studentUsername
	 */
	public String getStudentUsername() {
		return studentUsername;
	}

	/**
	 * @param studentUsername the studentUsername to set
	 */
	public void setStudentUsername(String studentUsername) {
		this.studentUsername = studentUsername;
	}

	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "StudentCourse [" 
				+ (courseId != null ? "courseId=" + courseId + ", " : "")
				+ (studentUsername != null ? "studentUsername=" + studentUsername + ", " : "")
				+ (courseName != null ? "courseName=" + courseName + ", " : "") 
				+ (timestamp != null ? "timestamp=" + timestamp + ", " : "")
				+ "grade=" + grade + ", "
				+ "fees=" + fees + ", credit=" + credit + ", " 
				+ (catalogueId != null ? "catalogueId=" + catalogueId : "") + "]";
	}
}
