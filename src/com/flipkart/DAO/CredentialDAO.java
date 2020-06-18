package com.flipkart.DAO;

import java.sql.SQLException;

/**
 * @author ciphereck
 * @category DAO Interface
 *
 */
public interface CredentialDAO {
	/**
	 * 
	 * @param username
	 * @param password
	 * @return Role of given User
	 * @throws SQLException
	 */
	public String checkIdentity(String username, String password) throws SQLException;
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @param role
	 * @return Added User Successfully
	 * @throws SQLException
	 */
	public int addUser(String username, String password, String role) throws SQLException;
	
	/**
	 * 
	 * @param username
	 * @return Deleted User Successfully
	 * @throws SQLException
	 */
	public int deleteUser(String username) throws SQLException;
}
