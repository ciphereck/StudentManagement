package com.flipkart.service;

public class AdminService extends CredentialService implements UserService {
	public void deleteUser(String username) {
		credentialDAO.deleteUser(username);
	}
	
	public void viewUsers() {
		credentialDAO.printAllUsers();
	}
}
