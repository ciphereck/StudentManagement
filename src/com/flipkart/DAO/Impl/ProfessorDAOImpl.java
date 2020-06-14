package com.flipkart.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.DAO.ProfessorDAO;
import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.model.Admin;
import com.flipkart.model.Professor;
import com.flipkart.model.User;

public class ProfessorDAOImpl implements ProfessorDAO {
	@Override
	public User convertToUser(ResultSet rs) {
		Professor professor = null;
		try {
			String username = rs.getString("username");
			String name = rs.getString("name");
			String gender = rs.getString("gender");
			String dob = rs.getString("dob");
			
			professor = new Professor(username, name, dob, gender);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return professor;
	}

	@Override
	public PreparedStatement getPreparedStatementForEditUser(User user, Connection conn) throws SQLException {
		Professor professor = (Professor) user;
		PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.UPDATE_PROFESSOR);
		statement.setString(1, professor.getName());
		statement.setString(2, professor.getDob());
		statement.setString(3, "" + professor.getGender());
		statement.setString(4, professor.getUsername());
		return statement;
	}

}
