package com.flipkart.model;

/**
 * @author ciphereck
 * @category Model
 *
 */
public class Student extends User {
	boolean registrationCompledted;

	/**
	 * @param username
	 * @param name
	 * @param dob
	 * @param gender
	 * @param registrationCompledted
	 */
	public Student(String username, String name, String dob, String gender, boolean registrationCompledted) {
		super(username, name, dob, gender);
		this.registrationCompledted = registrationCompledted;
	}

	/**
	 * @param username
	 * @param registrationCompledted
	 */
	public Student(String username, boolean registrationCompledted) {
		super(username);
		this.registrationCompledted = registrationCompledted;
	}

	/**
	 * @param registrationCompledted
	 */
	public Student(boolean registrationCompledted) {
		super();
		this.registrationCompledted = registrationCompledted;
	}

	/**
	 * @param username
	 * @param name
	 * @param dob
	 * @param gender
	 */
	public Student(String username, String name, String dob, String gender) {
		super(username, name, dob, gender);
	}

	/**
	 * @param username
	 */
	public Student(String username) {
		super(username);
	}

	/**
	 * 
	 */
	public Student() {
		super();
	}

	/**
	 * @return the registrationCompledted
	 */
	public boolean isRegistrationCompledted() {
		return registrationCompledted;
	}

	/**
	 * @param registrationCompledted the registrationCompledted to set
	 */
	public void setRegistrationCompledted(boolean registrationCompledted) {
		this.registrationCompledted = registrationCompledted;
	}
	
	/**
	 * @param registrationCompledted the registrationCompledted to set
	 */
	public void setRegistrationCompledted(int registrationCompledted) {
		this.registrationCompledted = !(registrationCompledted == 0);
	}

	@Override
	public String toString() {
		return "Student [" + (username != null ? "username=" + username + ", " : "") 
				+ (name != null ? "name=" + name + ", " : "") + (dob != null ? "dob=" + dob + ", " : "") 
				+ (gender != null ? "gender=" + gender + "," : "") + "registrationCompledted=" + registrationCompledted + "]";
	}	
}
