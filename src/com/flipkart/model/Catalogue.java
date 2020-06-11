package com.flipkart.model;

public class Catalogue {
	String courseId;
	String courseName;
	String professorUsername;
	
	public Catalogue(String courseId, String courseName, String professorUsername) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.professorUsername = professorUsername;
	}

	@Override
	public String toString() {
		return "id: " + courseId + ", name: " + courseName + ", prof: " + professorUsername;
	}
}
