package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.service.UserService;
import com.flipkart.service.Service;

public class RootClient {
	private static final Logger logger = Logger.getLogger(RootClient.class);
	private static int loginTry = 0;
	
	public static void main(String[] args) {
		logger.info("Pragram Started.....");
		showMenu();
		logger.info("End of Program");
	}
	
	public static void showMenu() {
		Scanner sc = new Scanner(System.in);
		int option;
		do {
			logger.info("0. To Exit");
			logger.info("1. Student Registration");
			logger.info("2. Login");
			
			option = sc.nextInt();
			if(option == 0) {
				return;
			}
			
			logger.error("Enter Username Password");
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
		UserService userService = new UserService();
		userService.addUser(username, password, "STUDENT");
		login(username, password);
	}

	public static void login(String username, String password) {
		UserService userService = new UserService();
		String typeOfUser = userService.checkIdentity(username, password);
		
		showSubClient(typeOfUser, username);
}
	
	public static void showSubClient(String typeOfUser, String username) {
		SubClient client = null;
		if("STUDENT".equals(typeOfUser)) {
			client = new StudentClient(username);
		} else if("PROFESSOR".equals(typeOfUser)) {
			client = new ProfessorClient();
		} else if("ADMIN".equals(typeOfUser)) {
			client = new AdminClient();
		} else {
			loginTry++;
			logger.info("wrong username / password function");
			return;
		}
		
		loginTry = 0;
		client.showMenu();
	}
}
