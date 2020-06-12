package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.utils.DBUtil;
import com.flipkart.utils.MySQLQuery;

public class ProfessorCourseDAOImpl implements ProfessourCourseDAO {
	private final Logger logger = Logger.getLogger(CatalogueDAO.class);
	
	@Override
	public void addCourseToTeach(String courseId, String username) {
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.ADD_PROFESSOR_COURSE);
			statement.setString(1, courseId);
			statement.setString(2, username);
			
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
			PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.DELETE_PROFESSOR_COURSE);
			statement.setString(1, courseId);
			statement.setString(2, username);
			
			int row = MySQLQuery.executeUpdate(statement);
			logger.info("Row affected: " + row);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}
	
}
