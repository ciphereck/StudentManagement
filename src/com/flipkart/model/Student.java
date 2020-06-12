package com.flipkart.model;

import org.apache.log4j.Logger;

public class Student implements User {
	String username;
	String name;
	String dob;
	char gender;
	private Logger logger = Logger.getLogger(Student.class);
	
	public Student(String username, String name, String dob, char gender) {
		super();
		this.username = username;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
	}
	
	public void printUser() {
		logger.info(this);
	}

	public Student(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
}
