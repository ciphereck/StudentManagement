package com.flipkart.model;

public class Catalogue {
	String courseId;
	String courseName;
	int fees;
	double credit;
	String timestamp = null;
	
	public Catalogue(String courseId, String courseName, int fees, double credit, String timestamp) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.fees = fees;
		this.credit = credit;
		this.timestamp = timestamp;
	}

	public Catalogue(String courseId, String courseName, int fees, double credit) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.fees = fees;
		this.credit = credit;
	}

	@Override
	public String toString() {
		String details = String
				.format("id: %s, name: %s, fees: %d, credit %.2f", 
						courseId, courseName, fees, credit);
		if(timestamp != null) {
			details = String.format("%s, lastUpdate: %s", details, timestamp);
		}
		return details;
	}
}
