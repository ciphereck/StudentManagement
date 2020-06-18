package com.flipkart.client;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.constant.Roles;
import com.flipkart.exception.IllegalObjectException;
import com.flipkart.exception.IllegalRoleException;
import com.flipkart.exception.ProfessorNotTeachingCourseException;
import com.flipkart.exception.StudentNotFoundException;
import com.flipkart.exception.StudentRegistrationNotCompletedException;
import com.flipkart.model.Admin;
import com.flipkart.model.Professor;
import com.flipkart.model.ProfessorCourse;
import com.flipkart.model.Student;
import com.flipkart.model.StudentCourse;
import com.flipkart.model.User;
import com.flipkart.service.ProfessorService;
import com.flipkart.service.UserService;
import com.flipkart.service.StudentService;

public class ProfessorClient implements SubClient {
	private static final Logger logger = Logger.getLogger(ProfessorClient.class);
	private final ProfessorService professorService = new ProfessorService();
	private Professor professor;
	private final Scanner sc = new Scanner(System.in);
	
	public ProfessorClient(String username) {
		showCurrentTime(true, Roles.PROFESSOR.toString());
		professor = new Professor(username);
	}
	
	public void showMenu() {
			Scanner sc = new Scanner(System.in);
			int option = 0;
			
			do {
				logger.info("0. logout");
				logger.info("1. Record Grades");
				logger.info("2. View Course");
				logger.info("3. Add Course to Teach");
				logger.info("4. Delete Course to teach");
				logger.info("5. View Teaching courses");
				logger.info("6. View Student's list");
				logger.info("7. View Students Grade");
				logger.info("8. Edit Details");
				logger.info("9. View My Details");
				
				option = sc.nextInt();
				
				if(option == 0) {
					break;
				}
				processOption(option);
			} while(option !=0);
			
			showCurrentTime(false, Roles.PROFESSOR.toString());
		}

	private void processOption(int option) {
		if(option == 1) {
			recordGrade();
		} else if(option == 2) {
			showAllCourses();
		} else if(option == 3) {
			addCourseToTeach();
		} else if(option == 4) {
			deleteCourseToTeach();
		} else if(option == 5) {
			viewMyCourses();
		} else if(option == 6) {
			viewStudentList();
		} else if(option == 7) {
			printReportCard();
		} else if(option == 8) {
			editDetails();
		} else if(option == 9) {
			viewDetails();
		}
	}
		
	public void recordGrade() {
		logger.info("Enter courseId, username, grade");
		String courseId = sc.next();
		String username = sc.next();
		String grade = sc.next();
		StudentCourse course = new StudentCourse();
		course.setStudentUsername(username);
		course.setCourseId(courseId);
		course.setGrade(grade);

		try {
			int res = professorService.updateGrades(course, professor.getUsername());
			logger.info("Student Grades Updated Successfully");
		} catch (SQLException | IllegalRoleException | StudentNotFoundException
				| ProfessorNotTeachingCourseException | StudentRegistrationNotCompletedException e) {
			logger.error(e.getMessage());
		}
				
	}
	
	public void addCourseToTeach() {
		String courseId = sc.next();
		ProfessorCourse course = new ProfessorCourse();
		course.setCourseId(courseId);
		course.setProfessourUsername(professor.getUsername());
		try {
			professorService.addCouseToTeach(course);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}
	
	public void deleteCourseToTeach() {
		String courseId = sc.next();
		ProfessorCourse course = new ProfessorCourse();
		course.setCourseId(courseId);
		course.setProfessourUsername(professor.getUsername());
		try {
			professorService.deleteCourseToTeach(course);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}
	
	public void viewMyCourses() {
		try {
			professorService
			.getTeachingCourses(professor.getUsername())
			.forEach(logger::info);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}
	
	public void viewStudentList() {
		try {
			professorService
				.getStudentTaughtByProfessor(professor.getUsername())
				.forEach(logger::info);
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
	}
	
	public void editDetails() {
		logger.info("Enter name, dob(YYYY-MM-DD) and gender (M/F)");

		professor.setName(sc.next());
		professor.setDob(sc.next());
		professor.setGender("" + sc.next().charAt(0));
		
		try {
			int row = professorService.editUser(professor);
			logger.info("Row affected: " + row);
		} catch (IllegalObjectException | SQLException e) {
			logger.error(e.getMessage());
		}
	}
	
	public void viewDetails() {
		try {
			User user = professorService.getDetailByUsername(professor.getUsername(), Roles.PROFESSOR.toString());
			if(user != null) {
				professor = (Professor) user;
				logger.info(professor);
			}
		} catch (SQLException | IllegalRoleException e) {
			logger.error(e.getMessage());
		}
	}
}
