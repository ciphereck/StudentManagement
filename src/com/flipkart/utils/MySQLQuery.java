package com.flipkart.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import org.apache.log4j.Logger;

/**
 * @author ciphereck
 * @category Util
 *
 */
public class MySQLQuery {
private static final Logger logger = Logger.getLogger(MySQLQuery.class);
	/**
	 * 
	 * @param statement
	 * @return Row Changed
	 */
	public static int executeUpdate(PreparedStatement statement) {
		int rows = 0;
		try {
			rows = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
		return rows;
	}
	
	/**
	 * 
	 * @param statement
	 * @return Result from MySQL
	 */
	public static ResultSet executeQuery(PreparedStatement statement) {
		ResultSet rs = null;
		try {
			rs = statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
		return rs;
	}
	
	/**
	 * 
	 * @return DateTime in String
	 */
	public static String getDateTime() {
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		return localDate + " " + localTime;
	}
}
