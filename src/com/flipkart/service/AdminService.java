package com.flipkart.service;

import java.util.List;

import com.flipkart.DAO.AdminDAO;
import com.flipkart.DAO.UserDAO;
import com.flipkart.DAO.Impl.AdminDAOImpl;
import com.flipkart.DAO.Impl.ProfessorDAOImpl;
import com.flipkart.DAO.Impl.StudentDAOImpl;
import com.flipkart.constant.Roles;
import com.flipkart.model.Admin;
import com.flipkart.model.Course;
import com.flipkart.model.Student;
import com.flipkart.model.User;

public class AdminService extends CredentialService implements UserService {	
	private Admin admin;
	private AdminDAO adminDAO = new AdminDAOImpl();
	
	public AdminService(Admin admin) {
		super();
		this.admin = admin;
	}

	public void deleteUser(String username) {
		credentialDAO.deleteUser(username);
	}
	
	public List<User> viewUsers(String role) {
		UserDAO userDAO = new StudentDAOImpl();
		if(role.equals("STUDENT")) {
			userDAO = new StudentDAOImpl();
		} else if(role.equals("PROFESSOR")) {
			userDAO = new ProfessorDAOImpl();
		} else if(role.equals("ADMIN")) {
			userDAO = new AdminDAOImpl();
		}
		return userDAO.getUserByRole(role + 's');
	}

	@Override
	public User getUser() {
		User user = adminDAO.getUserDetail(Roles.ADMIN.toString(), admin.getUsername());
		if(user != null && user instanceof Admin) {
			admin = (Admin) user;
		}
		return admin;
	}

	@Override
	public String getUsername() {
		return admin.getUsername();
	}
	
	public void addCatalogue(Course course) {
		catalogueDAO.addCourse(course);
	}
	
	public void editCatalogue(Course course) {
		catalogueDAO.editCourse(course);
	}
	
	public void removeCatalogue(String courseId) {
		catalogueDAO.deleteCourse(courseId);
	}
}
