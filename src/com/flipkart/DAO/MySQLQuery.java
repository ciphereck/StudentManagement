package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class MySQLQuery {
private static final Logger logger = Logger.getLogger(UserDAOImpl.class);
	
	public static int executeUpdate(Connection conn, PreparedStatement statement) {
		int rows = 0;
		
		try {
			rows = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.fatal(e.getMessage());
		}
		return rows;
	}
	
	public static ResultSet executeQuery(Connection conn, PreparedStatement statement) {
		ResultSet rs = null;
		
		try {
			rs = statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.fatal(e.getMessage());
		}
		return rs;
	}
}
