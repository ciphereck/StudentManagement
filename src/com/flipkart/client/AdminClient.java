package com.flipkart.client;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.flipkart.constant.Roles;
import com.flipkart.exception.IllegalObjectException;
import com.flipkart.exception.IllegalRoleException;
import com.flipkart.model.Admin;
import com.flipkart.model.Course;
import com.flipkart.model.Role;
import com.flipkart.model.User;
import com.flipkart.service.AdminService;

/**
 * @author ciphereck
 * @category Client
 *
 */
public class AdminClient implements SubClient {
	private final Logger logger = Logger.getLogger(AdminClient.class);
	private final AdminService adminService = new AdminService();
	private Admin admin;
	private final Scanner sc = new Scanner(System.in);
	
	/**
	 * @param username
	 */
	public AdminClient(String username) {
		showCurrentTime(true, Roles.ADMIN.toString());
		admin = new Admin(username);
	}
	
	/**
	 * Show Menu of Student
	 */
	public void showMenu() {
		int option = 0;
		
		do {
			logger.info("");
			logger.info("=================================");
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
			logger.info("=================================");
			logger.info("");
			
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
	
	private void addUser() {
		logger.info("Enter username, password, role");
		List<Role> roles;
		try {
			roles = adminService.getRoles();
		} catch (SQLException e) {
			logger.error(e.getMessage());
			return;
		}
		for(int i=0; i<roles.size(); i++) {
			logger.info("Enter " + (i+1) + " for " + roles.get(i));
		}
		
		String username = sc.next();
		String password = sc.next();
		int role = sc.nextInt();
		
		if(role -1 < roles.size()) {
			try {
				int row = adminService.addUser(username, password, roles.get(role-1).getRoleId());
				logger.info("Adding success: " + (row>0));
			} catch (SQLException e) {
				logger.info(e.getMessage());
			}
		} else {
			logger.error("Enter proper role");
		}
	}
	
	private void deleteUser() {
		logger.info("Enter username to remove");
		String username = sc.next();
		
		try {
			int row = adminService.deleteUser(username);
			logger.info("Deleting success: " + (row>0));
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}
	
	private void viewUser() {
		List<Role> roles;
		try {
			roles = adminService.getRoles();
		} catch (SQLException e) {
			logger.error(e.getMessage());
			return;
		}
		for(int i=0; i<roles.size(); i++) {
			logger.info("Enter " + (i+1) + " for " + roles.get(i));
		}
		int role = sc.nextInt();
		
		if(role - 1 < roles.size()) {
			Supplier<Stream<User>> users = () -> {
					try {
						return adminService
									.getUserByRole(roles.get(role-1).getRoleId())
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
	
	private void addCourse() {
		logger.info("Enter course info -> id name fees credit catalogueId");
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
	
	private void deleteCourse() {
		logger.info("Enter course id");
		String courseId = sc.next();
		try {
			adminService.deleteCourse(courseId);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}
	
	private void editCourse() {
		logger.info("Enter course info -> id name fees credit catalogueId");
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
	
	private void editDetails() {
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
	
	private void viewDetails() {
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
