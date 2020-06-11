package com.flipkart.service;

import org.apache.log4j.Logger;

import com.flipkart.DAO.UserDAO;
import com.flipkart.DAO.UserDAOImpl;

public class LoginService implements Service {
	Logger logger = Logger.getLogger(LoginService.class);
	UserDAO userDAO = new UserDAOImpl();
	
	public String checkIdentity(String username, String password) {
		String typeOfUser = userDAO.checkIdentity(username, password);
		logger.error(typeOfUser + " type of user found");
		return typeOfUser;
	}
}
