package com.flipkart.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.flipkart.constant.SqlQueryConstant;

public class LoginIdentityHelper extends MySQLQuery {
	String id;
	String password;
	
	public LoginIdentityHelper(String id, String password) {
		this.id = id;
		this.password = password;
	}
	

	@Override
	public PreparedStatement prepareQuery(Connection conn) throws SQLException {
		PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.AUTH_CRED_CHECK);
		
		statement.setString(1, id);
		statement.setString(2, password);
		
		return statement;
	}

}
