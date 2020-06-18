package com.flipkart.model;

/**
 * @author ciphereck
 * @category Model
 *
 */
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

	@Override
	public String toString() {
		return "Admin [" + (username != null ? "username=" + username + ", " : "")
				+ (name != null ? "name=" + name + ", " : "") + (dob != null ? "dob=" + dob + ", " : "")
				+ (gender != null ? "gender=" + gender : "") + "]";
	}
}
