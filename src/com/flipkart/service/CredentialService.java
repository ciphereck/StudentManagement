package com.flipkart.service;

import org.apache.log4j.Logger;

import com.flipkart.DAO.UserDAO;
import com.flipkart.DAO.UserDAOImpl;

public class CredentialService {
	Logger logger = Logger.getLogger(CredentialService.class);
	UserDAO userDAO = new UserDAOImpl();
	
	public final String checkIdentityAndRole(String username, String password) {
		String typeOfUser = userDAO.checkIdentity(username, password);
		if(typeOfUser.length() == 0) {
			logger.info("no user found");
			return typeOfUser;
		}
		return typeOfUser;
	}
	
	public String addUser(String username, String password, String role) {
		return userDAO.addUser(username, password, role);
	}
}
