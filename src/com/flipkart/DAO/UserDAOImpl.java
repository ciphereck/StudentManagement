package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.model.Catalogue;
import com.flipkart.utils.DBUtil;
import com.flipkart.utils.MySQLQuery;

public class UserDAOImpl implements UserDAO {
	private final Logger logger = Logger.getLogger(UserDAOImpl.class);

	@Override
	public String checkIdentity(String username, String password) {
		Connection conn = DBUtil.getConnection();
		int count = 0;
		String typeOfUser = "";
		
		try {
			PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.AUTH_CRED_CHECK);
			statement.setString(1, username);
			statement.setString(2, password);
			
			ResultSet rs = MySQLQuery.executeQuery(statement);
			while(rs.next()) {
					typeOfUser = rs.getString("type");
					count++;
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		
		return count==1 ? typeOfUser: "";
	}

	@Override
	public String addUser(String username, String password, String role) {
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.ADD_USER);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, role);
			
			int row = MySQLQuery.executeUpdate(statement);
			logger.info("Row affected: " + row);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return role;
	}

	@Override
	public void deleteUser(String username) {
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.DELETE_USER);
			statement.setString(1, username);
			
			int row = MySQLQuery.executeUpdate(statement);
			logger.info("Row affected: " + row);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void printAllUsers() {
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.GET_USER);
			
			ResultSet rs = MySQLQuery.executeQuery(statement);
			while(rs.next()) {
					String username = rs.getString("username");
					String type = rs.getString("type");

					logger.info("username: " + username + ", TYPE: " + type);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}
}
