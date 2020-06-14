package com.flipkart.service;

import java.util.List;

import com.flipkart.DAO.UserDAO;
import com.flipkart.DAO.Impl.AdminDAOImpl;
import com.flipkart.DAO.Impl.ProfessorDAOImpl;
import com.flipkart.DAO.Impl.StudentDAOImpl;
import com.flipkart.model.Admin;
import com.flipkart.model.User;

public class AdminService extends CredentialService implements UserService {	
	private Admin admin;
	
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
		return userDAO.printUserByType(role + 's');
	}
	
	public Admin getAdmin() {
		return admin;
	}
}
