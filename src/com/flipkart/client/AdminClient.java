package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.model.Admin;
import com.flipkart.model.Student;
import com.flipkart.service.AdminService;

public class AdminClient implements SubClient {
	private static final Logger logger = Logger.getLogger(StudentClient.class);
	AdminService adminService;
	String roleName[] = {"STUDENT", "PROFESSOR", "ADMIN"};
	
	public AdminClient(String username) {
		showCurrentTime(true, "ADMIN");
		adminService = new AdminService(new Admin(username));
	}
	
	public void showMenu() {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		
		do {
			logger.info("0. logout");
			logger.info("1. Add User");
			logger.info("2. Remove User");
			logger.info("3. View Users");
			logger.info("4. Generate Report Card");
			logger.info("5. Edit My Details");
			
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
			logger.info("Enter role as 1: Student, 2: Professor, 3: Admin");
			
			String username = sc.next();
			String password = sc.next();
			int role = sc.nextInt();
			
			if(role - 1 < roleName.length) {
				adminService.addUser(username, password, roleName[role-1]);
			} else {
				logger.info("Enter proper role");
			}
		} else if(option == 2) {
			logger.info("Enter username to remove");
			String username = sc.next();
			
			adminService.deleteUser(username);
		} else if(option == 3) {
			logger.info("Enter role as 1: Student, 2: Professor, 3: Admin");
			int role = sc.nextInt();
			
			if(role - 1 < roleName.length) {
				adminService
					.viewUsers(roleName[role-1])
					.stream()
					.filter(user -> user.getGender()=='M')
					.forEach(user -> logger.info("Mr. " + user.getName() + " " + user.getUsername()));
				
				adminService
					.viewUsers(roleName[role-1])
					.stream()
					.filter(user -> user.getGender()=='F')
					.forEach(user -> logger.info("Ms. " + user.getName() + " " + user.getUsername()));
			} else {
				logger.info("Enter proper role");
			}
		} else if(option == 5) {
			logger.info("Enter name, dob(YYYY-MM-DD) and gender (M/F)");
			
			Admin admin = adminService.getAdmin();
			admin.setName(sc.next());
			admin.setDob(sc.next());
			admin.setGender(sc.next().charAt(0));
			int row = adminService.editUser(admin);
			logger.info("Row affected: " + row);
		}
	}
}
