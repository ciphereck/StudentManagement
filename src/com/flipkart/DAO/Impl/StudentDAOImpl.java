package com.flipkart.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.DAO.StudentDAO;
import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.model.Admin;
import com.flipkart.model.Student;
import com.flipkart.model.User;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public User convertToUser(ResultSet rs) {
		Student student = null;
		try {
			String username = rs.getString("username");
			String name = rs.getString("name");
			String gender = rs.getString("gender");
			String dob = rs.getString("dob");
			int payment = rs.getInt("payment");
			
			student = new Student(username, name, dob, gender, payment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public PreparedStatement getPreparedStatementForEditUser(User user, Connection conn) throws SQLException {
		Student student = (Student) user;
		PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.UPDATE_STUDENT);
		statement.setString(1, student.getName());
		statement.setString(2, student.getDob());
		statement.setString(3, "" + student.getGender());
		statement.setString(4, student.getUsername());
		return statement;
	}

}
