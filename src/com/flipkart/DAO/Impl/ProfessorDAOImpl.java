package com.flipkart.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.DAO.ProfessorDAO;
import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.exception.IllegalObjectException;
import com.flipkart.model.Professor;
import com.flipkart.model.User;

/**
 * @author ciphereck
 * @category DAO Implementation
 *
 */
public class ProfessorDAOImpl implements ProfessorDAO {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public User convertToUser(ResultSet rs) throws SQLException {
		Professor professor = new Professor();
		
		professor.setUsername(rs.getString("username"));
		professor.setName(rs.getString("name"));
		professor.setGender(rs.getString("gender"));
		professor.setDob(rs.getString("dob"));
		
		return professor;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PreparedStatement getPreparedStatementForEditUser(User user, Connection conn) throws SQLException, IllegalObjectException {
		if(!(user instanceof Professor)) {
			throw new IllegalObjectException(Professor.class.getClass().getName(), user.getClass().getName());
		}
		
		Professor professor = (Professor) user;
		PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.UPDATE_PROFESSOR);
		statement.setString(1, professor.getName());
		statement.setString(2, professor.getDob());
		statement.setString(3, professor.getGender());
		statement.setString(4, professor.getUsername());
		return statement;
	}
}
