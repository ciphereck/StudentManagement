package com.flipkart.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.DAO.CredentialDAO;
import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.utils.DBUtil;
import com.flipkart.utils.MySQLQuery;

public class CredentialDAOImpl implements CredentialDAO {
	@Override
	public String checkIdentity(String username, String password) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String typeOfUser = "";
		
		PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.AUTH_CHECK_USERS);
		statement.setString(1, username);
		statement.setString(2, password);
		
		ResultSet rs = MySQLQuery.executeQuery(statement);
		while(rs!= null && rs.next()) {
				typeOfUser = rs.getString("role");
		}
		
		return typeOfUser;
	}

	@Override
	public int addUser(String username, String password, String role) throws SQLException {
		Connection conn = DBUtil.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.ADD_USER);
		statement.setString(1, username);
		statement.setString(2, password);
		statement.setString(3, role);
		
		return MySQLQuery.executeUpdate(statement);
	}

	@Override
	public int deleteUser(String username) throws SQLException {
		Connection conn = DBUtil.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.DELETE_USER);
		statement.setString(1, username);
		
		return MySQLQuery.executeUpdate(statement);
	}
}
