package com.flipkart.exception;

/**
 * @author ciphereck
 * @category Exception
 *
 */
public class IllegalObjectException extends Exception {
	String fromObject;
	String toObject;
	
	/**
	 * @param toObject
	 * @param fromObject
	 */
	public IllegalObjectException(String toObject, String fromObject) {
		super();
		this.fromObject = fromObject;
		this.toObject = toObject;
	}
	
	@Override
	public String getMessage() {
		return "Object required of type " + toObject + " but found " + fromObject;
	}
}
