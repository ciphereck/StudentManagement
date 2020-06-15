package com.flipkart.model;

public class StudentRegistration {
	String studentUsername;
	String regId;
	int fees;
	String paymentId;
	String paymentModeId;
	
	public StudentRegistration(String studentUsername, String regId, int fees, String paymentId, String paymentModeId) {
		super();
		this.studentUsername = studentUsername;
		this.regId = regId;
		this.fees = fees;
		this.paymentId = paymentId;
		this.paymentModeId = paymentModeId;
	}

	public String getPaymentModeId() {
		return paymentModeId;
	}



	public void setPaymentModeId(String paymentModeId) {
		this.paymentModeId = paymentModeId;
	}



	/**
	 * @return the studentUsername
	 */
	public String getStudentUsername() {
		return studentUsername;
	}
	/**
	 * @param studentUsername the studentUsername to set
	 */
	public void setStudentUsername(String studentUsername) {
		this.studentUsername = studentUsername;
	}
	/**
	 * @return the regId
	 */
	public String getRegId() {
		return regId;
	}
	/**
	 * @param regId the regId to set
	 */
	public void setRegId(String regId) {
		this.regId = regId;
	}
	/**
	 * @return the fees
	 */
	public int getFees() {
		return fees;
	}
	/**
	 * @param fees the fees to set
	 */
	public void setFees(int fees) {
		this.fees = fees;
	}
	/**
	 * @return the paymentId
	 */
	public String getPaymentId() {
		return paymentId;
	}
	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	
	
}
