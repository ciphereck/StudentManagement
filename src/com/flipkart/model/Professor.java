package com.flipkart.model;

import org.apache.log4j.Logger;

public class Professor implements User {
	String username;
	String name;
	String dob;
	String gender;
	private Logger logger = Logger.getLogger(Professor.class);
	
	public Professor(String username, String name, String dob, String gender) {
		this.username = username;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
	}

	public Professor(String username) {
		this.username = username;
	}
	
	public void printUser() {
		logger.info(this);
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
