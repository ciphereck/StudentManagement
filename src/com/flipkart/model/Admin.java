package com.flipkart.model;

import org.apache.log4j.Logger;

public class Admin implements User {
	String username;
	String name;
	String dob;
	char gender;
	private Logger logger = Logger.getLogger(Admin.class);
	
	public Admin(String username, String name, String dob, char gender) {
		this.username = username;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
	}

	public Admin(String username) {
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
}
