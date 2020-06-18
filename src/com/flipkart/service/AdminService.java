package com.flipkart.service;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.DAO.AdminDAO;
import com.flipkart.DAO.CourseDAO;
import com.flipkart.DAO.RoleDAO;
import com.flipkart.DAO.UserDAO;
import com.flipkart.DAO.Impl.AdminDAOImpl;
import com.flipkart.DAO.Impl.CourseDAOImpl;
import com.flipkart.DAO.Impl.ProfessorDAOImpl;
import com.flipkart.DAO.Impl.RoleDAOImpl;
import com.flipkart.DAO.Impl.StudentDAOImpl;
import com.flipkart.constant.Roles;
import com.flipkart.exception.IllegalRoleException;
import com.flipkart.model.Course;
import com.flipkart.model.Role;
import com.flipkart.model.User;

/**
 * @author ciphereck
 * @category Service
 *
 */
public class AdminService extends CredentialService implements UserService {	
	private CourseDAO courseDAO = new CourseDAOImpl();
	private RoleDAO roleDAO = new RoleDAOImpl();

	/**
	 * 
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public int deleteUser(String username) throws SQLException {
		return credentialDAO.deleteUser(username);
	}
	
	/**
	 * 
	 * @param role
	 * @return
	 * @throws IllegalRoleException
	 * @throws SQLException
	 */
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
	
	/**
	 * 
	 * @param course
	 * @return
	 * @throws SQLException
	 */
	public int addCourse(Course course) throws SQLException {
		return courseDAO.addCourse(course);
	}
	
	/**
	 * 
	 * @param course
	 * @return
	 * @throws SQLException
	 */
	public int editCourse(Course course) throws SQLException {
		return courseDAO.editCourse(course);
	}
	
	/**
	 * 
	 * @param courseId
	 * @return
	 * @throws SQLException
	 */
	public int deleteCourse(String courseId) throws SQLException {
		return courseDAO.deleteCourse(courseId);
	}
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Role> getRoles() throws SQLException {
		return roleDAO.getRoles();
	}
}
