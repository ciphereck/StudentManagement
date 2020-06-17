package com.flipkart.service;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.DAO.AdminDAO;
import com.flipkart.DAO.CourseDAO;
import com.flipkart.DAO.UserDAO;
import com.flipkart.DAO.Impl.AdminDAOImpl;
import com.flipkart.DAO.Impl.CourseDAOImpl;
import com.flipkart.DAO.Impl.ProfessorDAOImpl;
import com.flipkart.DAO.Impl.StudentDAOImpl;
import com.flipkart.constant.Roles;
import com.flipkart.exception.IllegalRoleException;
import com.flipkart.model.Course;
import com.flipkart.model.User;

public class AdminService extends CredentialService {	
	private CourseDAO courseDAO = new CourseDAOImpl();

	public void deleteUser(String username) throws SQLException {
		credentialDAO.deleteUser(username);
	}
	
	public List<User> getUserByRole(String role) throws IllegalRoleException, SQLException {
		UserDAO userDAO = null;
		
		if(Roles.STUDENT.toString().equals(role)) {
			userDAO = new StudentDAOImpl();
		} else if(Roles.PROFESSOR.toString().equals(role)) {
			userDAO = new ProfessorDAOImpl();
		} else if(Roles.ADMIN.toString().equals(role)) {
			userDAO = new AdminDAOImpl();
		} else {
			throw new IllegalRoleException(role);
		}
		return userDAO.getUserByRole(role);
	}
	
	public void addCourse(Course course) throws SQLException {
		courseDAO.addCourse(course);
	}
	
	public void editCourse(Course course) throws SQLException {
		courseDAO.editCourse(course);
	}
	
	public void deleteCourse(String courseId) throws SQLException {
		courseDAO.deleteCourse(courseId);
	}
}
