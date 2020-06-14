package com.flipkart.DAO;

import java.util.List;

import com.flipkart.model.Student;

public interface StudentDAO extends UserDAO {
	public List<Student> getStudentByProfessor(String username);
}
