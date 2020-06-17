package com.flipkart.DAO;

import java.sql.SQLException;

public interface CredentialDAO {
	public String checkIdentity(String username, String password) throws SQLException;
	public int addUser(String username, String password, String role) throws SQLException;
	public int deleteUser(String username) throws SQLException;
}
