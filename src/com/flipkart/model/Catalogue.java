package com.flipkart.model;

public class Catalogue {
	String courseId;
	String courseName;
	
	public Catalogue(String courseId, String courseName) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
	}

	@Override
	public String toString() {
		return "id: " + courseId + ", name: " + courseName;
	}
}
