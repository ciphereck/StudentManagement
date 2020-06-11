package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.service.LoginService;
import com.flipkart.service.Service;

public class RootClient {
	private static final Logger logger = Logger.getLogger(RootClient.class);
	
	public static void main(String[] args) {
		logger.info("Pragram Started.....");
		showMenu();
	}
	
	public static void showMenu() {
		Scanner sc = new Scanner(System.in);
		int option;
		do {
			logger.info("0. To Exit");
			logger.info("1. Student Registration");
			logger.info("2. Login");
			
			option = sc.nextInt();
			if(option == 2) {
				login();
			} else {
				logger.info("Enter Some Other Option");
			}

		} while(option != 0);
	}
	
	public static void login() {
		logger.error("Enter Username Password");
		Scanner sc = new Scanner(System.in);
			
		String username = sc.next();
		String password = sc.next();
			
		LoginService loginService = new LoginService();
		String typeOfUser = loginService.checkIdentity(username, password);
		
		showSubClient(typeOfUser, username);
}
	
	public static void showSubClient(String typeOfUser, String username) {
		if("STUDENT".equals(typeOfUser)) {
			StudentClient studentClient = new StudentClient(username);
			studentClient.showMenu();
		} else if("PROFESSOR".equals(typeOfUser)) {
			ProfessorClient professorClient = new ProfessorClient();
			professorClient.showMenu();
		} else if("ADMIN".equals(typeOfUser)) {
			AdminClient adminClient = new AdminClient();
			adminClient.showMenu();
		} else {
			logger.info("wrong username / password function");
		}
	}
}
