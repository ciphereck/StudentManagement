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

public class CatalogueDAOImpl implements CatalogueDAO {
	private final Logger logger = Logger.getLogger(CatalogueDAO.class);
	
	@Override
	public void printCatalogue() {
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.GET_CATALOGUE);
			
			ResultSet rs = MySQLQuery.executeQuery(statement);
			while(rs.next()) {
					String courseId = rs.getString("courseId");
					String courseName = rs.getString("courseName");

					logger.info(new Catalogue(courseId, courseName).toString());
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}
	
	@Override
	public void printCatalogueByStudentUsername(String username) {
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.GET_COURSE_BY_STUDENT);
			statement.setString(1, username);
			statement.setString(2, username);
			
			ResultSet rs = MySQLQuery.executeQuery(statement);
			while(rs.next()) {
				String courseId = rs.getString("courseId");
				String courseName = rs.getString("courseName");
				String lastUpdateTime = rs.getString("timeofLastUpdate");

				logger.info(new Catalogue(courseId, courseName, lastUpdateTime).toString());
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void printCatalogueByProfessorUsername(String username) {
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.GET_COURSE_BY_PROFESSOR);
			statement.setString(1, username);
			
			ResultSet rs = MySQLQuery.executeQuery(statement);
			while(rs.next()) {
				String courseId = rs.getString("courseId");
				String courseName = rs.getString("courseName");

				logger.info(new Catalogue(courseId, courseName).toString());
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}

}
