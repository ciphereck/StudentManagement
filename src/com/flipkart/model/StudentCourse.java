package com.flipkart.model;

public class StudentCourse {
	String courseId;
	String grades;
	String username;
	
	public StudentCourse(String courseId, String grades, String username) {
		super();
		this.courseId = courseId;
		this.grades = grades;
		this.username = username;
	}

	@Override
	public String toString() {
		return "StudentCourse [courseId=" + courseId + ", grades=" + grades + "]";
	}
	
	
}
