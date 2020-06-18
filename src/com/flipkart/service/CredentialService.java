package com.flipkart.service;

import java.sql.SQLException;

import com.flipkart.DAO.CredentialDAO;
import com.flipkart.DAO.Impl.CredentialDAOImpl;
import com.flipkart.exception.BadCredentialException;

/**
 * @author ciphereck
 * @category Service
 *
 */
public class CredentialService {
	CredentialDAO credentialDAO = new CredentialDAOImpl();
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 * @throws BadCredentialException
	 */
	public final String checkIdentityAndRole(String username, String password) throws SQLException, BadCredentialException {
		String typeOfUser = credentialDAO.checkIdentity(username, password);
		if(typeOfUser==null || typeOfUser.length() == 0) {
			throw new BadCredentialException();
		}
		return typeOfUser;
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @param role
	 * @return
	 * @throws SQLException
	 */
	public int addUser(String username, String password, String role) throws SQLException {
		return credentialDAO.addUser(username, password, role);
	}
}
