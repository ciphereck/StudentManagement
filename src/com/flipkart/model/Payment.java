package com.flipkart.model;

public class Payment {
	String paymentMode;
	String paymentModeId;
	String paymentDescription;
	
	/**
	 * @param paymentMode
	 * @param paymentModeId
	 * @param paymentDescription
	 */
	public Payment(String paymentMode, String paymentModeId, String paymentDescription) {
		super();
		this.paymentMode = paymentMode;
		this.paymentModeId = paymentModeId;
		this.paymentDescription = paymentDescription;
	}

	/**
	 * 
	 */
	public Payment() {
		super();
	}

	/**
	 * @return the paymentMode
	 */
	public String getPaymentMode() {
		return paymentMode;
	}

	/**
	 * @param paymentMode the paymentMode to set
	 */
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
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

	/**
	 * @return the paymentDescription
	 */
	public String getPaymentDescription() {
		return paymentDescription;
	}

	/**
	 * @param paymentDescription the paymentDescription to set
	 */
	public void setPaymentDescription(String paymentDescription) {
		this.paymentDescription = paymentDescription;
	}

	@Override
	public String toString() {
		return "Payment [" + (paymentMode != null ? "paymentMode=" + paymentMode + ", " : "")
				+ (paymentModeId != null ? "paymentModeId=" + paymentModeId + ", " : "")
				+ (paymentDescription != null ? "paymentDescription=" + paymentDescription : "") + "]";
	}
}
