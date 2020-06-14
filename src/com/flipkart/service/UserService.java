package com.flipkart.service;

import java.util.List;

import com.flipkart.DAO.UserDAO;
import com.flipkart.DAO.Impl.AdminDAOImpl;
import com.flipkart.DAO.Impl.CatalogueDAOImpl;
import com.flipkart.DAO.Impl.ProfessorDAOImpl;
import com.flipkart.DAO.Impl.StudentCourseDAOImpl;
import com.flipkart.DAO.Impl.StudentDAOImpl;
import com.flipkart.constant.Roles;
import com.flipkart.model.Admin;
import com.flipkart.model.Catalogue;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;
import com.flipkart.model.StudentCourse;
import com.flipkart.model.User;

public interface UserService {
	CatalogueDAOImpl catalogueDAO = new CatalogueDAOImpl();
	
	public default List<Catalogue> printCatalogue() {
		return catalogueDAO.printCatalogue();
	}
	
	public default int editUser(User user) {
		UserDAO userDAO = null;
		if(user instanceof Student) {
			userDAO = new StudentDAOImpl();
		} else if(user instanceof Professor) {
			userDAO = new ProfessorDAOImpl();
		} else if(user instanceof Admin) {
			userDAO = new AdminDAOImpl();
		} else {
			return 0;
		}
		
		return userDAO.editUser(user);
	}
	
	default public User getDetailByUsername(String username, String role) {
		UserDAO userDAO = null;
		if(Roles.ADMIN.toString().equals(role)) {
			userDAO = new AdminDAOImpl();
		} else if(Roles.PROFESSOR.toString().equals(role)) {
			userDAO = new ProfessorDAOImpl();
		} else if(Roles.STUDENT.toString().equals(role)) {
			userDAO = new StudentDAOImpl();
		} else {
			return null;
		}
		User user = userDAO.getUserDetail(Roles.STUDENT.toString(), username);
		return user;
	}
	
	public User getUser();
	public String getUsername();
	
	default public List<StudentCourse> getReportCard(String username) {
		return (new StudentCourseDAOImpl()).getReportCard(username);
	}
}
