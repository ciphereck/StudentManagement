package com.flipkart.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.flipkart.DAO.CredentialDAO;
import com.flipkart.DAO.Impl.CredentialDAOImpl;
import com.flipkart.exception.BadCredentialException;

public class CredentialService {
	CredentialDAO credentialDAO = new CredentialDAOImpl();
	
	public final String checkIdentityAndRole(String username, String password) throws SQLException, BadCredentialException {
		String typeOfUser = credentialDAO.checkIdentity(username, password);
		if(typeOfUser==null || typeOfUser.length() == 0) {
			throw new BadCredentialException();
		}
		return typeOfUser;
	}
	
	public int addUser(String username, String password, String role) throws SQLException {
		return credentialDAO.addUser(username, password, role);
	}
}
