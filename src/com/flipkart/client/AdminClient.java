package com.flipkart.client;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.flipkart.constant.Roles;
import com.flipkart.exception.IllegalObjectException;
import com.flipkart.exception.IllegalRoleException;
import com.flipkart.model.Admin;
import com.flipkart.model.Course;
import com.flipkart.model.User;
import com.flipkart.service.AdminService;

public class AdminClient implements SubClient {
	private final Logger logger = Logger.getLogger(AdminClient.class);
	private final AdminService adminService = new AdminService();
	private Admin admin;
	private final Scanner sc = new Scanner(System.in);
	
	
	public AdminClient(String username) {
		showCurrentTime(true, Roles.ADMIN.toString());
		admin = new Admin(username);
	}
	
	public void showMenu() {
		int option = 0;
		
		do {
			logger.info("0. logout");
			logger.info("1. Add User");
			logger.info("2. Remove User");
			logger.info("3. View Users");
			logger.info("4. View Courses");
			logger.info("5. View Student's Report Card");
			logger.info("6. Add Course");
			logger.info("7. Delete Course");
			logger.info("8. Update Course");
			logger.info("9. Edit My Details");
			logger.info("10. View My Details");
			
			option = sc.nextInt();
			
			if(option == 0) {
				break;
			}
			processOption(option);
		} while(option !=0);
		
		showCurrentTime(false, Roles.ADMIN.toString());
	}

	private void processOption(int option) {
		if(option == 1) {
			addUser();
		} else if(option == 2) {
			deleteUser();
		} else if(option == 3) {
			viewUser();
		} else if(option == 4) {
			showAllCourses();
		} else if(option == 5) {
			printReportCard();
		} else if(option == 6) {
			addCourse();
		} else if(option == 7) {
			deleteCourse();
		} else if(option == 8) {
			editCourse();
		}  else if(option == 9) {
			editDetails();
		} else if(option == 10) {
			viewDetails();
		}
	}
	
	public void addUser() {
		logger.info("Enter username, password, role");
		logger.info("Enter role as 1: Student, 2: Professor, 3: Admin");
		
		String username = sc.next();
		String password = sc.next();
		int role = sc.nextInt();
		
		if(role - 1 < Roles.values().length) {
			try {
				int row = adminService.addUser(username, password, Roles.values()[role-1].toString());
				logger.info("Adding success: " + (row>0));
			} catch (SQLException e) {
				logger.info(e.getMessage());
			}
		} else {
			logger.error("Enter proper role");
		}
	}
	
	public void deleteUser() {
		logger.info("Enter username to remove");
		String username = sc.next();
		
		try {
			int row = adminService.deleteUser(username);
			logger.info("Deleting success: " + (row>0));
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}
	
	public void viewUser() {
		logger.info("Enter role as 1: Student, 2: Professor, 3: Admin");
		int role = sc.nextInt();
		
		if(role - 1 < Roles.values().length) {
			Supplier<Stream<User>> users = () -> {
					try {
						return adminService
									.getUserByRole(Roles.values()[role-1].toString())
									.stream();
					} catch (IllegalRoleException | SQLException e) {
						logger.error(e.getMessage());
					}
					return null;
				};
			
			if(users != null) {
				users
					.get()
					.filter(user -> user.getGender() != null)
					.filter(user -> user.getGender().charAt(0)=='M')
					.forEach(user -> logger.info("Mr. " + user.getName() + " " + user.getUsername()));
		
				users
					.get()
					.filter(user -> user.getGender() != null)
					.filter(user -> user.getGender().charAt(0)=='F')
					.forEach(user -> logger.info("Ms. " + user.getName() + " " + user.getUsername()));
		
				users
					.get()
					.filter(user -> user.getGender() == null)
					.forEach(user -> logger.info("Mr./Ms. " + user.getName() + " " + user.getUsername()));
			}
			
		} else {
			logger.error("Enter proper role");
		}
	}
	
	public void addCourse() {
		String courseId = sc.next();
		String courseName = sc.next();
		int fees = sc.nextInt();
		double credit = sc.nextDouble();
		String catalogueId = sc.next();
		
		Course course = new Course(courseId, courseName, fees, credit, catalogueId);
		try {
			adminService.addCourse(course);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}
	
	public void deleteCourse() {
		String courseId = sc.next();
		try {
			adminService.deleteCourse(courseId);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}
	
	public void editCourse() {
		String courseId = sc.next();
		String courseName = sc.next();
		int fees = sc.nextInt();
		double credit = sc.nextDouble();
		String catalogueId = sc.next();
		
		Course course = new Course(courseId, courseName, fees, credit, catalogueId);
		try {
			adminService.editCourse(course);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}
	
	public void editDetails() {
		logger.info("Enter name, dob(YYYY-MM-DD) and gender (M/F)");

		admin.setName(sc.next());
		admin.setDob(sc.next());
		admin.setGender("" + sc.next().charAt(0));
		
		try {
			int row = adminService.editUser(admin);
			logger.info("Row affected: " + row);
		} catch (IllegalObjectException | SQLException e) {
			logger.error(e.getMessage());
		}
	}
	
	public void viewDetails() {
		try {
			User user = adminService.getDetailByUsername(admin.getUsername(), Roles.ADMIN.toString());
			if(user != null) {
				admin = (Admin) user;
				logger.info(admin);
			}
		} catch (SQLException | IllegalRoleException e) {
			logger.error(e.getMessage());
		}
	}
}
