package com.flipkart.client;

import java.sql.SQLException;
import java.util.Scanner;
import org.apache.log4j.Logger;

import com.flipkart.constant.Roles;
import com.flipkart.exception.BadCredentialException;
import com.flipkart.service.CredentialService;

public class RootClient {
	private static final Logger logger = Logger.getLogger(RootClient.class);
	private static final Scanner sc = new Scanner(System.in);
	private static final CredentialService credentialService = new CredentialService();
	private static int loginTry = 0;
	
	public static void main(String[] args) {
		logger.info("Pragram Started.....");
		showMenu();
		logger.info("End of Program");
	}
	
	public static void showMenu() {
		
		int option;
		do {
			logger.info("0. To Exit");
			logger.info("1. Student Registration");
			logger.info("2. Login");
			
			option = sc.nextInt();
			if(option == 0) {
				return;
			}
			
			logger.info("Enter Username Password");
			String username = sc.next();
			String password = sc.next();
			
			if(option == 1) {
				registerStudent(username, password);
			} else if(option == 2) {
				login(username, password);
			} else {
				logger.info("Enter Some Other Option");
			}

		} while(loginTry < 4);
	}
	
	private static void registerStudent(String username, String password) {
		try {
			int row = credentialService.addUser(username, password, Roles.STUDENT.toString());
			if(row == 0) {
				loginTry++;
				logger.error("Duplicate username, Please select another username");
				return;
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			return;
		}
		
		login(username, password);
	}

	public static void login(String username, String password) {
		try {
			String typeOfUser = credentialService.checkIdentityAndRole(username, password);
			showSubClient(typeOfUser, username);
		} catch (SQLException | BadCredentialException e) {
			logger.error(e.getMessage());
		}
	}
	
	public static void showSubClient(String typeOfUser, String username) {
		SubClient client = null;
		if(Roles.STUDENT.toString().equals(typeOfUser)) {
			client = new StudentClient(username);
		} else if(Roles.PROFESSOR.toString().equals(typeOfUser)) {
			client = new ProfessorClient(username);
		} else if(Roles.ADMIN.toString().equals(typeOfUser)) {
			client = new AdminClient(username);
		} else {
			loginTry++;
			logger.info("wrong username / password function");
			return;
		}
		
		loginTry = 0;
		client.showMenu();
	}
}
