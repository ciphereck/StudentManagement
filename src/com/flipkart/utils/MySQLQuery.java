package com.flipkart.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.flipkart.DAO.UserDAOImpl;

public class MySQLQuery {
private static final Logger logger = Logger.getLogger(UserDAOImpl.class);
	
	public static int executeUpdate(PreparedStatement statement) {
		int rows = 0;
		try {
			rows = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.fatal(e.getMessage());
		}
		return rows;
	}
	
	public static ResultSet executeQuery(PreparedStatement statement) {
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
