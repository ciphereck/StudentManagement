package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.model.Student;
import com.flipkart.service.StudentService;

public class StudentClient implements SubClient {
	private final Logger logger = Logger.getLogger(StudentClient.class);
	private final StudentService studentService;
	
	public StudentClient(String username) {
		showCurrentTime(true, "STUDENT");
		this.studentService = new StudentService(new Student(username));
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
			
			processOption(option);
		} while(option !=0);
		
		showCurrentTime(false, "STUDENT");
	}

	private void processOption(int option) {
		Scanner sc = new Scanner(System.in);
		if(option == 0) {
			return;
		} else if(option == 1) {
			studentService
				.getAllCourses()
				.forEach(logger::info);
		} else if(option == 2) {
			String courseId = sc.next();
			studentService.addStudentCourse(courseId);
		} else if(option == 3) {
			String courseId = sc.next();
			studentService.deleteStudentCourse(courseId);
		} else if(option == 4) {
			studentService
				.getStudentCourse()
				.forEach(logger::info);
		} else if(option == 5) {
			int regStatus = studentService.registerStudent();
			if(regStatus == -1) {
				logger.info("Wrong Number of courses");
			} else if(regStatus == -2) {
				logger.info("payment failed.....No Money will deduct from your account");
			} else if(regStatus == 0) {
				logger.info("payment succeed. Registration failed.... Your transaction will be reverted");
			} else {
				logger.info("Congrats! You have registered for Courses successfully");
			}
		} else if(option == 6) {
			studentService
				.getReportCard(studentService.getUsername())
				.forEach(logger::info);
		} else if(option == 7) {
			logger.info("Enter name, dob(YYYY-MM-DD) and gender (M/F)");
			
			Student student = (Student)studentService.getUser();
			student.setName(sc.next());
			student.setDob(sc.next());
			student.setGender("" + sc.next().charAt(0));
			int row = studentService.editUser(student);
			logger.info("Row affected: " + row);
		} else if(option == 8) {
			Student student = (Student) studentService.getUser();
			logger.info(student);
		}
	}
}
