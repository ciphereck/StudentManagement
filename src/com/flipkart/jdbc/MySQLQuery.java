package com.flipkart.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.flipkart.DAO.UserDAOImpl;

import java.sql.Connection;

public abstract class MySQLQuery {
	private static final Logger logger = Logger.getLogger(UserDAOImpl.class);
	
	public int executeUpdate(Connection conn) {
		PreparedStatement statement = null;
		int rows = 0;
		
		try {
			statement = prepareQuery(conn);
			rows = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.fatal(e.getMessage());
		}
		return rows;
	}
	
	public ResultSet executeQuery(Connection conn) {
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		try {
			statement = prepareQuery(conn);
			rs = statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.fatal(e.getMessage());
		}
		return rs;
	}
	
	public abstract PreparedStatement prepareQuery(Connection conn) throws SQLException;
}
