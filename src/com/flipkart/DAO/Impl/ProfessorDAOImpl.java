package com.flipkart.DAO.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.DAO.ProfessorDAO;
import com.flipkart.model.Professor;
import com.flipkart.model.User;

public class ProfessorDAOImpl implements ProfessorDAO {
	@Override
	public User convertToUser(ResultSet rs) {
		Professor professor = null;
		try {
			String username = rs.getString("username");
			String name = rs.getString("name");
			char gender = rs.getString("gender").charAt(0);
			String dob = rs.getString("dob");
			
			professor = new Professor(username, name, dob, gender);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return professor;
	}

}
