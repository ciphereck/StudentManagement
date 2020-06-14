package com.flipkart.model;

import org.apache.log4j.Logger;

public class Student implements User {
	String username;
	String name;
	String dob;
	String gender;
	int payment;
	private Logger logger = Logger.getLogger(Student.class);
	
	public Student(String username, String name, String dob, String gender, int payment) {
		super();
		this.username = username;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.payment = payment;
	}

	public Student(String username) {
		super();
		this.username = username;
	}

	@Override
	public void printUser() {
		logger.info(this);
	}
	
	@Override
	public String toString() {
		return "Student [username=" + username + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", payment="
				+ payment + "]";
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

	/**
	 * @return the payment
	 */
	public int getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(int payment) {
		this.payment = payment;
	}
}
