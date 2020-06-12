package com.flipkart.model;

public class Catalogue {
	String courseId;
	String courseName;
	String lastUpdateTime = "";
	
	public Catalogue(String courseId, String courseName, String lastUpdateTime) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.lastUpdateTime = lastUpdateTime;
	}

	public Catalogue(String courseId, String courseName) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
	}

	@Override
	public String toString() {
		if(!(lastUpdateTime!= null && lastUpdateTime.length()==0))
			return "id: " + courseId + ", name: " + courseName + ", lastUpdate: " + lastUpdateTime;
		else
			return "id: " + courseId + ", name: " + courseName;
	}
}
