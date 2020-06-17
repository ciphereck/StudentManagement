package com.flipkart.model;


public class Professor extends User {

	/**
	 * 
	 */
	public Professor() {
		super();
	}

	/**
	 * @param username
	 * @param name
	 * @param dob
	 * @param gender
	 */
	public Professor(String username, String name, String dob, String gender) {
		super(username, name, dob, gender);
	}

	/**
	 * @param username
	 */
	public Professor(String username) {
		super(username);
	}
	
}
