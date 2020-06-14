package com.flipkart.service;

import java.util.List;

import com.flipkart.DAO.UserDAO;
import com.flipkart.DAO.Impl.AdminDAOImpl;
import com.flipkart.DAO.Impl.CatalogueDAOImpl;
import com.flipkart.DAO.Impl.ProfessorDAOImpl;
import com.flipkart.DAO.Impl.StudentDAOImpl;
import com.flipkart.model.Admin;
import com.flipkart.model.Catalogue;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;
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
	
	public User getUser();
}
