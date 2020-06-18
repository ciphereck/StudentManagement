package com.flipkart.model;

public class Admin extends User {
	/**
	 * 
	 */
	public Admin() {
		super();
	}

	/**
	 * @param username
	 * @param name
	 * @param dob
	 * @param gender
	 */
	public Admin(String username, String name, String dob, String gender) {
		super(username, name, dob, gender);
	}

	/**
	 * @param username
	 */
	public Admin(String username) {
		super(username);
	}
}
