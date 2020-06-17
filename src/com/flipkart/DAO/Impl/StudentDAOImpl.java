package com.flipkart.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.DAO.StudentDAO;
import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.exception.IllegalObjectException;
import com.flipkart.model.Student;
import com.flipkart.model.User;
import com.flipkart.utils.DBUtil;
import com.flipkart.utils.MySQLQuery;

public class StudentDAOImpl implements StudentDAO {
	@Override
	public User convertToUser(ResultSet rs) throws SQLException {
		Student student = new Student();
			
		student.setUsername(rs.getString("username"));
		student.setName(rs.getString("name"));
		student.setGender(rs.getString("gender"));
		student.setDob(rs.getString("dob"));
		student.setRegistrationCompledted(rs.getInt("registrationDone"));
		
		return student;
	}

	@Override
	public PreparedStatement getPreparedStatementForEditUser(User user, Connection conn) throws SQLException, IllegalObjectException {
		if(!(user instanceof Student)) {
			throw new IllegalObjectException(Student.class.getClass().getName(), user.getClass().getName());
		}
		
		Student student = (Student) user;
		PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.UPDATE_STUDENT);
		statement.setString(1, student.getName());
		statement.setString(2, student.getDob());
		statement.setString(3, student.getGender());
		statement.setString(4, student.getUsername());
		return statement;
	}

	@Override
	public List<Student> getStudentByProfessor(String username) throws SQLException {
		Connection conn = DBUtil.getConnection();
		List<Student> students = new ArrayList<>();
		
		PreparedStatement statement = conn
				.prepareStatement(SqlQueryConstant.GET_STUDENT_LIST_FOR_PROFESSOR);
		statement.setString(1, username);

		ResultSet rs = MySQLQuery.executeQuery(statement);
		while(rs!=null && rs.next()) {
			students.add((Student) convertToUser(rs));
		}
		
		return students;
	}

}
