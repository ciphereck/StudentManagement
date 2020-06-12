package com.flipkart.DAO.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.DAO.StudentDAO;
import com.flipkart.model.Student;
import com.flipkart.model.User;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public User convertToUser(ResultSet rs) {
		Student student = null;
		try {
			String username = rs.getString("username");
			String name = rs.getString("name");
			char gender = rs.getString("gender").charAt(0);
			String dob = rs.getString("dob");
			
			student = new Student(username, name, dob, gender);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

}
