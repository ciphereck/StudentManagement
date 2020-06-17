package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.model.Admin;
import com.flipkart.model.Course;
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
			logger.info("4. View Catalogue");
			logger.info("5. View Student's Report Card");
			logger.info("6. Add Catalogue");
			logger.info("7. Delete Catalogue");
			logger.info("8. Update Catalogue");
			logger.info("9. Edit My Details");
			logger.info("10. View My Details");
			
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
					.getUserByRole(roleName[role-1])
					.stream()
					.filter(user -> user.getGender() != null)
					.filter(user -> user.getGender().charAt(0)=='M')
					.forEach(user -> logger.info("Mr. " + user.getName() + " " + user.getUsername()));
				
				adminService
					.getUserByRole(roleName[role-1])
					.stream()
					.filter(user -> user.getGender() != null)
					.filter(user -> user.getGender().charAt(0)=='F')
					.forEach(user -> logger.info("Ms. " + user.getName() + " " + user.getUsername()));
				
				adminService
					.getUserByRole(roleName[role-1])
					.stream()
					.filter(user -> user.getGender() == null)
					.forEach(user -> logger.info("Mr./Ms. " + user.getName() + " " + user.getUsername()));
			} else {
				logger.info("Enter proper role");
			}
		} else if(option == 4) {
			adminService
				.getAllCourses()
				.forEach(logger::info);
		} else if(option == 5) {
			String username = sc.next();
			adminService
				.getReportCard(username)
				.forEach(logger::info);
		} else if(option == 6) {
			String courseId = sc.next();
			String courseName = sc.next();
			int fees = sc.nextInt();
			double credit = sc.nextDouble();
			String catalogueId = sc.next();
			
			Course course = new Course(courseId, courseName, fees, credit, catalogueId);
			adminService.addCourse(course);
		} else if(option == 7) {
			String courseId = sc.next();
			adminService.deleteCourse(courseId);
		} else if(option == 8) {
			String courseId = sc.next();
			String courseName = sc.next();
			int fees = sc.nextInt();
			double credit = sc.nextDouble();
			String catalogueId = sc.next();
			
			Course course = new Course(courseId, courseName, fees, credit, catalogueId);
			adminService.editCourse(course);
		}  else if(option == 9) {
			logger.info("Enter name, dob(YYYY-MM-DD) and gender (M/F)");
			
			Admin admin = (Admin)adminService.getUser();
			admin.setName(sc.next());
			admin.setDob(sc.next());
			admin.setGender("" + sc.next().charAt(0));
			int row = adminService.editUser(admin);
			logger.info("Row affected: " + row);
		} else if(option == 10) {
			Admin admin = (Admin) adminService.getUser();
			logger.info(admin);
		}
	}
}
