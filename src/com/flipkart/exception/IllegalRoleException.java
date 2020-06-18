package com.flipkart.exception;

/**
 * @author ciphereck
 * @category Exception
 *
 */
public class IllegalRoleException extends Exception {
	String role;

	/**
	 * @param role
	 */
	public IllegalRoleException(String role) {
		super();
		this.role = role;
	}

	@Override
	public String getMessage() {
		return role + " is not a valid Role";
	}
}
