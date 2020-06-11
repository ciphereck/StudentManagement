package com.flipkart.service;

import org.apache.log4j.Logger;

import com.flipkart.DAO.UserDAO;
import com.flipkart.DAO.UserDAOImpl;

public class UserService implements Service {
	Logger logger = Logger.getLogger(UserService.class);
	UserDAO userDAO = new UserDAOImpl();
	
	public String checkIdentity(String username, String password) {
		String typeOfUser = userDAO.checkIdentity(username, password);
		logger.info(typeOfUser + " type of user found");
		return typeOfUser;
	}
	
	public void addUser(String username, String password, String role) {
		userDAO.addUser(username, password, role);
	}
	
	public void deleteUser(String username) {
		userDAO.deleteUser(username);
	}
	
	public void viewUsers() {
		userDAO.printAllUsers();
	}
}
