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
			PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.GET_CATALOGUE);
			
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
		return 0;
	}

	@Override
	public int editCatalogue(Catalogue catalogue) {
		return 0;
	}

	@Override
	public int deleteCatalogue(String courseId) {
		return 0;
	}
	
	
}
