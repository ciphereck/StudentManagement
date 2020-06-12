package com.flipkart.service;

import org.apache.log4j.Logger;

import com.flipkart.DAO.CredentialDAO;
import com.flipkart.DAO.Impl.CredentialDAOImpl;

public class CredentialService {
	Logger logger = Logger.getLogger(CredentialService.class);
	CredentialDAO credentialDAO = new CredentialDAOImpl();
	
	public final String checkIdentityAndRole(String username, String password) {
		String typeOfUser = credentialDAO.checkIdentity(username, password);
		if(typeOfUser.length() == 0) {
			logger.info("no user found");
			return typeOfUser;
		}
		return typeOfUser;
	}
	
	public String addUser(String username, String password, String role) {
		return credentialDAO.addUser(username, password, role);
	}
}
