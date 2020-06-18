package com.flipkart.DAO;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.model.Student;

/**
 * @author ciphereck
 * @category DAO Interface
 *
 */
public interface StudentDAO extends UserDAO {
	public List<Student> getStudentByProfessor(String username) throws SQLException;
}
