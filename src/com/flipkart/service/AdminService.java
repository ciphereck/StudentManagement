package com.flipkart.service;

public class AdminService extends CredentialService implements UserService {
	public void deleteUser(String username) {
		userDAO.deleteUser(username);
	}
	
	public void viewUsers() {
		userDAO.printAllUsers();
	}
}
