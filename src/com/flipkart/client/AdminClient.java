package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.service.UserService;

public class AdminClient implements SubClient {
	private static final Logger logger = Logger.getLogger(StudentClient.class);
	UserService userService = new UserService();
	
	public AdminClient() {
		showCurrentTime(true, "ADMIN");
	}
	
	public void showMenu() {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		
		do {
			logger.info("0. logout");
			logger.info("1. Add User");
			logger.info("2. Remove User");
			logger.info("3. View Users");
			logger.info("3. Generate Report Card");
			
			option = sc.nextInt();
			
			if(option == 0) {
				break;
			}
			processOption(option);
		} while(option !=0);
		
		showCurrentTime(false, "ADMIN");
	}

	private void processOption(int option) {
		Scanner sc = new Scanner(System.in);
		if(option == 1) {
			logger.info("Enter username, password, role");
			logger.info("Enter role as 1: student, 2: Professor, 3: Admin");
			String roleName[] = {"STUDENT", "PROFESSOR", "ADMIN"};
			
			String username = sc.next();
			String password = sc.next();
			int role = sc.nextInt();
			
			if(role - 1 < roleName.length) {
				userService.addUser(username, password, roleName[role-1]);
			} else {
				logger.info("Enter proper role");
			}
		} else if(option == 2) {
			logger.info("Enter username to remove");
			String username = sc.next();
			
			userService.deleteUser(username);
		} else if(option == 3) {
			userService.viewUsers();
		}
	}
}
