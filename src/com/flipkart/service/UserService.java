package com.flipkart.service;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.DAO.UserDAO;
import com.flipkart.DAO.Impl.AdminDAOImpl;
import com.flipkart.DAO.Impl.CourseDAOImpl;
import com.flipkart.DAO.Impl.ProfessorDAOImpl;
import com.flipkart.DAO.Impl.StudentCourseDAOImpl;
import com.flipkart.DAO.Impl.StudentDAOImpl;
import com.flipkart.constant.Roles;
import com.flipkart.exception.IllegalObjectException;
import com.flipkart.exception.IllegalRoleException;
import com.flipkart.model.Admin;
import com.flipkart.model.Course;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;
import com.flipkart.model.StudentCourse;
import com.flipkart.model.User;

/**
 * @author ciphereck
 * @category Service
 *
 */
public interface UserService {
	CourseDAOImpl catalogueDAO = new CourseDAOImpl();
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws IllegalObjectException
	 * @throws SQLException
	 */
	default public int editUser(User user) throws IllegalObjectException, SQLException {
		UserDAO userDAO = null;
		if(user instanceof Student) {
			userDAO = new StudentDAOImpl();
		} else if(user instanceof Professor) {
			userDAO = new ProfessorDAOImpl();
		} else if(user instanceof Admin) {
			userDAO = new AdminDAOImpl();
		} else {
			throw new IllegalObjectException("One of Role", user.getClass().getName());
		}
		return userDAO.editUser(user);
	}
	
	/**
	 * 
	 * @param username
	 * @param role
	 * @return
	 * @throws SQLException
	 * @throws IllegalRoleException
	 */
	default public User getDetailByUsername(String username, String role) throws SQLException, IllegalRoleException {
		UserDAO userDAO = null;
		if(Roles.ADMIN.toString().equals(role)) {
			userDAO = new AdminDAOImpl();
		} else if(Roles.PROFESSOR.toString().equals(role)) {
			userDAO = new ProfessorDAOImpl();
		} else if(Roles.STUDENT.toString().equals(role)) {
			userDAO = new StudentDAOImpl();
		} else {
			throw new IllegalRoleException(role);
		}
		User user = userDAO.getUserDetail(role, username);
		return user;
	}
}
