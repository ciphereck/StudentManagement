package com.flipkart.model;

/**
 * @author ciphereck
 * @category Model
 *
 */
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

	@Override
	public String toString() {
		return "Professor [" + (username != null ? "username=" + username + ", " : "")
				+ (name != null ? "name=" + name + ", " : "") + (dob != null ? "dob=" + dob + ", " : "")
				+ (gender != null ? "gender=" + gender : "") + "]";
	}
}
