package com.flipkart.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.flipkart.DAO.CatalogueDAO;
import com.flipkart.DAO.StudentCourseDAO;
import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.utils.DBUtil;
import com.flipkart.utils.MySQLQuery;

public class StudentCourseDAOImpl implements StudentCourseDAO {
	private final Logger logger = Logger.getLogger(CatalogueDAO.class);

	@Override
	public void addCourse(String courseId, String username) {
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.ADD_SYUDENT_COURSE);
			statement.setString(1, courseId);
			statement.setString(2, username);
//			statement.setString(3, MySQLQuery.getDateTime());
			
			
			int row = MySQLQuery.executeUpdate(statement);
			logger.info("Row affected: " + row);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void deleteCourse(String courseId, String username) {
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.DELETE_STUDENT_COURSE);
			statement.setString(1, courseId);
			statement.setString(2, username);
			
			int row = MySQLQuery.executeUpdate(statement);
			logger.info("Row affected: " + row);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}
	
	
	
	

}