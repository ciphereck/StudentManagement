package com.flipkart.DAO;

public interface CredentialDAO {
	public String checkIdentity(String username, String password);
	public String addUser(String username, String password, String role);
	public void deleteUser(String username);
}
