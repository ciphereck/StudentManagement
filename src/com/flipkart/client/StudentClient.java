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
			logger.info("1. View Catalogue");
			logger.info("2. Add Course");
			logger.info("3. Drop Course");
			logger.info("4. View Course");
			logger.info("5. View Report Card");
			logger.info("6. Pay Fee");
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
				.printCatalogue()
				.forEach(logger::info);
		} else if(option == 2) {
			String courseId = sc.next();
			studentService.addStudentCourse(courseId);
		} else if(option == 3) {
			String courseId = sc.next();
			studentService.deleteStudentCourse(courseId);
		} else if(option == 4) {
			studentService
				.printStudentCourse()
				.forEach(logger::info);
		} else if(option == 7) {
			logger.info("Enter name, dob(YYYY-MM-DD) and gender (M/F)");
			
			Student student = studentService.getStudent();
			student.setName(sc.next());
			student.setDob(sc.next());
			student.setGender(sc.next().charAt(0));
			int row = studentService.editUser(student);
			logger.info("Row affected: " + row);
		}
	}
}
