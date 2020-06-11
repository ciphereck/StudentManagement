package com.flipkart.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.flipkart.constant.SqlQueryConstant;

public class LoginIdentityHelper extends MySQLQuery {
	String username;
	String password;
	
	public LoginIdentityHelper(String username, String password) {
		this.username = username;
		this.password = password;
	}
	

	@Override
	public PreparedStatement prepareQuery(Connection conn) throws SQLException {
		PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.AUTH_CRED_CHECK);
		
		statement.setString(1, username);
		statement.setString(2, password);
		
		return statement;
	}

}
