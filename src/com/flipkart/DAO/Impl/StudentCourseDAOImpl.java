package com.flipkart.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.DAO.CatalogueDAO;
import com.flipkart.DAO.StudentCourseDAO;
import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.model.Course;
import com.flipkart.model.StudentCourse;
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

	@Override
	public int updateGrade(String courseId, String grade, String username) {
		Connection conn = DBUtil.getConnection();
		int row = 0;
		try {
			PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.UPDATE_STUDENT_GRADE);
			statement.setString(1, grade);
			statement.setString(2, username);
			statement.setString(3, courseId);
			
			row = MySQLQuery.executeUpdate(statement);
			logger.info("Row affected: " + row);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return row;
	}

	@Override
	public List<StudentCourse> getReportCard(String username) {
		List<StudentCourse> course = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		
		try {
			PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.GET_GRADES_BY_STUDENT);
			statement.setString(1, username);
			
			ResultSet rs = MySQLQuery.executeQuery(statement);
			while(rs.next()) {
					String courseId = rs.getString("courseId");
					String grades = rs.getString("grades");

					course.add(new StudentCourse(courseId, grades, username));
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		
		return course;
	}
	
	
}
