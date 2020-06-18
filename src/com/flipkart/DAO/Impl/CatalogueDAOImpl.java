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
import com.flipkart.model.Catalogue;
import com.flipkart.utils.DBUtil;
import com.flipkart.utils.MySQLQuery;

public class CatalogueDAOImpl implements CatalogueDAO {
	private final Logger logger = Logger.getLogger(CatalogueDAO.class);
	
	@Override
	public List<Catalogue> printCatalogue() {
		List<Catalogue> catalogue = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.GET_COURSE);
			
			ResultSet rs = MySQLQuery.executeQuery(statement);
			while(rs.next()) {
					String courseId = rs.getString("courseId");
					String courseName = rs.getString("courseName");
					int fees = rs.getInt("fees");
					double credit = rs.getDouble("credit");

					catalogue.add(new Catalogue(courseId, courseName, fees, credit));
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		
		return catalogue;
	}
	
	@Override
	public List<Catalogue> printCatalogueByStudentUsername(String username) {
		List<Catalogue> catalogue = new ArrayList<>();
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

				catalogue.add(new Catalogue(courseId, courseName, fees, credit, timestamp));
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return catalogue;
	}

	@Override
	public List<Catalogue> printCatalogueByProfessorUsername(String username) {
		List<Catalogue> catalogue = new ArrayList<>();
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

				catalogue.add(new Catalogue(courseId, courseName, fees, credit));
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return catalogue;
	}

	@Override
	public int addCatalogue(Catalogue catalogue) {
		Connection conn = DBUtil.getConnection();
		int row = 0;
		try {
			PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.ADD_COURSE);
			statement.setString(1, catalogue.getCourseId());
			statement.setString(2, catalogue.getCourseName());
			statement.setInt(3, catalogue.getFees());
			statement.setDouble(4, catalogue.getCredit());
			
			row = MySQLQuery.executeUpdate(statement);
			logger.info("Row affected: " + row);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return row;
	}

	@Override
	public int editCatalogue(Catalogue catalogue) {
		Connection conn = DBUtil.getConnection();
		int row = 0;
		try {
			PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.UPDATE_COURSE);
			statement.setString(4, catalogue.getCourseId());
			statement.setString(1, catalogue.getCourseName());
			statement.setInt(2, catalogue.getFees());
			statement.setDouble(3, catalogue.getCredit());
			statement.setString(5, catalogue.getCourseId());
			
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
