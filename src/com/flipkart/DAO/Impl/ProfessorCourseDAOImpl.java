package com.flipkart.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.flipkart.DAO.ProfessourCourseDAO;
import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.model.ProfessorCourse;
import com.flipkart.utils.DBUtil;
import com.flipkart.utils.MySQLQuery;

/**
 * @author ciphereck
 * @category DAO Implementation
 *
 */
public class ProfessorCourseDAOImpl implements ProfessourCourseDAO {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int addCourseToTeach(ProfessorCourse professorCourse) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.ADD_PROFESSOR_COURSE);
		statement.setString(1, professorCourse.getCourseId());
		statement.setString(2, professorCourse.getProfessourUsername());
		
		return MySQLQuery.executeUpdate(statement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int deleteCourseToTeach(ProfessorCourse professorCourse) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.DELETE_PROFESSOR_COURSE);
		statement.setString(1, professorCourse.getCourseId());
		statement.setString(2, professorCourse.getProfessourUsername());
		
		return MySQLQuery.executeUpdate(statement);
	}
	
}
