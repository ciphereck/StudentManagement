package com.flipkart.model;

/**
 * @author ciphereck
 * @category Model
 *
 */
public class User {
	String username;
	String name;
	String dob;
	String gender;
	
	/**
	 * @param username
	 * @param name
	 * @param dob
	 * @param gender
	 */
	public User(String username, String name, String dob, String gender) {
		super();
		this.username = username;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
	}
	
	/**
	 * @param username
	 */
	public User(String username) {
		super();
		this.username = username;
	}

	/**
	 * 
	 */
	public User() {
		super();
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [" + (username != null ? "username=" + username + ", " : "")
				+ (name != null ? "name=" + name + ", " : "") + (dob != null ? "dob=" + dob + ", " : "")
				+ (gender != null ? "gender=" + gender : "") + "]";
	}
}
