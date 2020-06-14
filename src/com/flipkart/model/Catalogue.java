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
		return "Catalogue [courseId=" + courseId + ", courseName=" + courseName + ", fees=" + fees + ", credit="
				+ credit + ", lastUpdate=" + timestamp + "]";
	}
}
