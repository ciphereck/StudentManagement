package com.flipkart.model;

/**
 * @author ciphereck
 * @category Model
 *
 */
public class StudentRegistration {
	String studentUsername;
	String regId;
	int fees;
	String transactionId;
	String paymentModeId;
	
	/**
	 * @param studentUsername
	 * @param regId
	 * @param fees
	 * @param transactionId
	 * @param paymentModeId
	 */
	public StudentRegistration(String studentUsername, String regId, int fees, String transactionId,
			String paymentModeId) {
		super();
		this.studentUsername = studentUsername;
		this.regId = regId;
		this.fees = fees;
		this.transactionId = transactionId;
		this.paymentModeId = paymentModeId;
	}

	/**
	 * 
	 */
	public StudentRegistration() {
		super();
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
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the paymentModeId
	 */
	public String getPaymentModeId() {
		return paymentModeId;
	}

	/**
	 * @param paymentModeId the paymentModeId to set
	 */
	public void setPaymentModeId(String paymentModeId) {
		this.paymentModeId = paymentModeId;
	}

	@Override
	public String toString() {
		return "StudentRegistration [" + (studentUsername != null ? "studentUsername=" + studentUsername + ", " : "")
				+ (regId != null ? "regId=" + regId + ", " : "") + "fees=" + fees + ", "
				+ (transactionId != null ? "transactionId=" + transactionId + ", " : "")
				+ (paymentModeId != null ? "paymentModeId=" + paymentModeId : "") + "]";
	}
}
