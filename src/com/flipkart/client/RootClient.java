package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.service.LoginService;
import com.flipkart.service.Service;

public class RootClient implements Client {
	private static final Logger logger = Logger.getLogger(RootClient.class);
	
	public static void main(String[] args) {
		logger.error("Pragram Started.....");
		login();
	}
	
	public static void login() {
		logger.error("Enter Username Password");
		Scanner sc = new Scanner(System.in);
			
		String username = sc.next();
		String password = sc.next();
			
		LoginService loginService = new LoginService();
		String typeOfUser = loginService.checkIdentity(username, password);
		
		showSubClient(typeOfUser);
}
	
	public static void showSubClient(String typeOfUser) {
		if("STUDENT".equals(typeOfUser)) {
			StudentClient studentClient = new StudentClient();
			studentClient.showMenu();
		} else if("PROFESSOR".equals(typeOfUser)) {
			ProfessorClient professorClient = new ProfessorClient();
			professorClient.showMenu();
		} else if("ADMIN".equals(typeOfUser)) {
			AdminClient adminClient = new AdminClient();
			adminClient.showMenu();
		} else {
			logger.error("wrong username / password function");
		}
	}
}
