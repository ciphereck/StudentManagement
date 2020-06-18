package com.flipkart.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.DAO.CatalogueDAO;
import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.model.Course;
import com.flipkart.utils.DBUtil;
import com.flipkart.utils.MySQLQuery;

public class CatalogueDAOImpl implements CatalogueDAO {
	private final Logger logger = Logger.getLogger(CatalogueDAO.class);
	
	@Override
	public List<Course> printCatalogue() {
		List<Course> course = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.GET_COURSE);
			
			ResultSet rs = MySQLQuery.executeQuery(statement);
			while(rs.next()) {
					String courseId = rs.getString("courseId");
					String courseName = rs.getString("courseName");
					int fees = rs.getInt("fees");
					double credit = rs.getDouble("credit");
					String catalogueId = rs.getString("catalogueId");

					course.add(new Course(courseId, courseName, fees, credit, catalogueId));
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		
		return course;
	}
	
	@Override
	public List<Course> printCatalogueByStudentUsername(String username) {
		List<Course> course = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.GET_COURSE_BY_STUDENT);
			statement.setString(1, username);
			statement.setString(2, username);
			
			ResultSet rs = MySQLQuery.executeQuery(statement);
			while(rs.next()) {
				String courseId = rs.getString("courseId");
				String courseName = rs.getString("courseName");
				int fees = rs.getInt("fees");
				double credit = rs.getDouble("credit");
				String timestamp = rs.getString("timeOfLastUpdate");
				String catalogueId = rs.getString("catalogueId");

				course.add(new Course(courseId, courseName, fees, credit, timestamp, catalogueId));
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return course;
	}

	@Override
	public List<Course> printCatalogueByProfessorUsername(String username) {
		List<Course> course = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.GET_COURSE_BY_PROFESSOR);
			statement.setString(1, username);
			
			ResultSet rs = MySQLQuery.executeQuery(statement);
			while(rs.next()) {
				String courseId = rs.getString("courseId");
				String courseName = rs.getString("courseName");
				int fees = rs.getInt("fees");
				double credit = rs.getDouble("credit");
				String catalogueId = rs.getString("catalogueId");

				course.add(new Course(courseId, courseName, fees, credit, catalogueId));
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return course;
	}

	@Override
	public int addCatalogue(Course course) {
		Connection conn = DBUtil.getConnection();
		int row = 0;
		try {
			PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.ADD_COURSE);
			statement.setString(1, course.getCourseId());
			statement.setString(2, course.getCourseName());
			statement.setInt(3, course.getFees());
			statement.setDouble(4, course.getCredit());
			statement.setString(5, course.getCatalogueId());
			
			row = MySQLQuery.executeUpdate(statement);
			logger.info("Row affected: " + row);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return row;
	}

	@Override
	public int editCatalogue(Course course) {
		Connection conn = DBUtil.getConnection();
		int row = 0;
		try {
			PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.UPDATE_COURSE);
			statement.setString(6, course.getCourseId());
			statement.setString(1, course.getCourseName());
			statement.setInt(2, course.getFees());
			statement.setDouble(3, course.getCredit());
			statement.setString(5, course.getCourseId());
			statement.setString(4, course.getCatalogueId());
			
			row = MySQLQuery.executeUpdate(statement);
			logger.info("Row affected: " + row);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return row;
	}

	@Override
	public int deleteCatalogue(String courseId) {
		Connection conn = DBUtil.getConnection();
		int row = 0;
		try {
			PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.DELETE_COURSE);
			statement.setString(1, courseId);
			statement.setString(2, courseId);
			
			row = MySQLQuery.executeUpdate(statement);
			logger.info("Row affected: " + row);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return row;
	}
	
	
}
