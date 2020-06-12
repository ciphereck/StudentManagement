package com.flipkart.service;

import org.apache.log4j.Logger;

import com.flipkart.DAO.UserDAO;
import com.flipkart.DAO.UserDAOImpl;

public class UserService implements Service {
	Logger logger = Logger.getLogger(UserService.class);
	UserDAO userDAO = new UserDAOImpl();
	
	public String checkIdentity(String username, String password) {
		String typeOfUser = userDAO.checkIdentity(username, password);
		if(typeOfUser.length() == 0) {
			logger.info("no user found");
			return typeOfUser;
		}
		logger.info(typeOfUser + " type of user found");
		return typeOfUser;
	}
	
	public String addUser(String username, String password, String role) {
		return userDAO.addUser(username, password, role);
	}
	
	public void deleteUser(String username) {
		userDAO.deleteUser(username);
	}
	
	public void viewUsers() {
		userDAO.printAllUsers();
	}
}
