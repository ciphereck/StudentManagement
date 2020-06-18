package com.flipkart.client;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.constant.Roles;
import com.flipkart.exception.IllegalObjectException;
import com.flipkart.exception.IllegalRoleException;
import com.flipkart.exception.PaymentFailedException;
import com.flipkart.exception.PaymentSucceedRegistrationFailedException;
import com.flipkart.exception.WrongNoOfCourseException;
import com.flipkart.model.Admin;
import com.flipkart.model.Student;
import com.flipkart.model.StudentCourse;
import com.flipkart.model.User;
import com.flipkart.service.StudentService;

public class StudentClient implements SubClient {
	private final Logger logger = Logger.getLogger(StudentClient.class);
	private final StudentService studentService = new StudentService();
	Scanner sc = new Scanner(System.in);
	private Student student;
	
	public StudentClient(String username) {
		showCurrentTime(true, Roles.STUDENT.toString());
		student = new Student(username);
	}
	
	public void showMenu() {
		int option = 0;
		do {
			logger.info("0. Logout");
			logger.info("1. View Course");
			logger.info("2. Add Course to My Courses");
			logger.info("3. Drop Course from My Courses");
			logger.info("4. View My Course");
			logger.info("5. Pay Fee and Register");
			logger.info("6. View Report Card");
			logger.info("7. Edit Details");
			logger.info("8. View My Details");
			
			Scanner sc = new Scanner(System.in);
			option = sc.nextInt();
			if(option == 0) {
				return;
			}
			
			processOption(option);
		} while(option !=0);
		
		showCurrentTime(false, Roles.STUDENT.toString());
	}

	private void processOption(int option) {
		if(option == 1) {
			showAllCourses();
		} else if(option == 2) {
			addMyCourse();
		} else if(option == 3) {
			deleteMyCourse();
		} else if(option == 4) {
			viewMyCourse();
		} else if(option == 5) {
			payAndRegister();
		} else if(option == 6) {
			printReportCard();
		} else if(option == 7) {
			editDetails();
		} else if(option == 8) {
			viewDetails();
		}
	}
	
	public void addMyCourse() {
		String courseId = sc.next();
		StudentCourse course = new StudentCourse();
		course.setCourseId(courseId);
		course.setStudentUsername(student.getUsername());
		try {
			studentService.addStudentCourse(course);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}
	
	public void deleteMyCourse() {
		String courseId = sc.next();
		StudentCourse course = new StudentCourse();
		course.setCourseId(courseId);
		course.setStudentUsername(student.getUsername());
		try {
			studentService.deleteStudentCourse(course);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}
	
	public void viewMyCourse() {
		try {
			studentService
				.getStudentCourse(student.getUsername())
				.forEach(logger::info);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}
	
	public void payAndRegister() {
		try {
			studentService.registerStudent(student.getUsername());
			logger.info("Congrats! You have registered for Courses successfully");
		} catch (SQLException | WrongNoOfCourseException | PaymentFailedException
				| PaymentSucceedRegistrationFailedException e) {
			logger.error(e.getMessage());
		}
	}
	
	public void printReportCard() {
		StudentCourse course = new StudentCourse();
		course.setStudentUsername(student.getUsername());
		printReportCard(course);
	}
	
	public void editDetails() {
		logger.info("Enter name, dob(YYYY-MM-DD) and gender (M/F)");

		student.setName(sc.next());
		student.setDob(sc.next());
		student.setGender("" + sc.next().charAt(0));
		
		try {
			int row = studentService.editUser(student);
			logger.info("Row affected: " + row);
		} catch (IllegalObjectException | SQLException e) {
			logger.error(e.getMessage());
		}
	}
	
	public void viewDetails() {
		try {
			User user = studentService.getDetailByUsername(student.getUsername(), Roles.STUDENT.toString());
			if(user != null) {
				student = (Student) user;
				logger.info(student);
			}
		} catch (SQLException | IllegalRoleException e) {
			logger.error(e.getMessage());
		}
	}
}
