package com.flipkart.model;

/**
 * @author ciphereck
 * @category Model
 *
 */
public class Transaction {
	String paymentModeid;
	String transactionId;

	/**
	 * 
	 */
	public Transaction() {
		super();
	}
	
	/**
	 * @return the paymentModeid
	 */
	public String getPaymentModeid() {
		return paymentModeid;
	}
	
	/**
	 * @param paymentModeid the paymentModeid to set
	 */
	public void setPaymentModeid(String paymentModeid) {
		this.paymentModeid = paymentModeid;
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

	@Override
	public String toString() {
		return "Transaction [" + (paymentModeid != null ? "paymentModeid=" + paymentModeid + ", " : "")
				+ (transactionId != null ? "transactionId=" + transactionId : "") + "]";
	}
}
