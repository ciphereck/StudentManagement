package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.model.Admin;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;
import com.flipkart.service.ProfessorService;
import com.flipkart.service.UserService;
import com.flipkart.service.StudentService;

public class ProfessorClient implements SubClient {
	private static final Logger logger = Logger.getLogger(ProfessorClient.class);
	private final ProfessorService professorService;
	
	public ProfessorClient(String username) {
		showCurrentTime(true, "PROFESSOR");
		this.professorService = new ProfessorService(new Professor(username));
	}
	
	public void showMenu() {
			Scanner sc = new Scanner(System.in);
			int option = 0;
			
			do {
				logger.info("0. logout");
				logger.info("1. Record Grades");
				logger.info("2. View Catalogue");
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
			
			showCurrentTime(false, "PROFESSOR");
		}

	private void processOption(int option) {
		Scanner sc = new Scanner(System.in);
		if(option == 1) {
			logger.info("Enter courseId, username, grade");
			String courseId = sc.next();
			String username = sc.next();
			String grade = sc.next();
			int res = professorService.updateGrades(courseId, username, grade);
			if(res == -1) {
				logger.info("no such student");
			} else if(res == -2) {
				logger.info("student not registered");
			} else if(res == 0) {
				logger.info("DB error");
			} else if(res == -3) {
				logger.info("You are not teaching this course");
			} else {
				logger.info("Student Grades Updated Successfully");
			}
		} else if(option == 2) {
			professorService
				.printAllCourses()
				.forEach(logger::info);
		} else if(option == 3) {
			String courseId = sc.next();
			professorService.addCouseToTeach(courseId);
		} else if(option == 4) {
			String courseId = sc.next();
			professorService.deleteCourseToTeach(courseId);
		} else if(option == 5) {
			professorService
			.viewCoursesToTeach()
			.forEach(logger::info);
		} else if(option == 7) {
			String username = sc.next();
			professorService
				.getReportCard(username)
				.forEach(logger::info);
		} else if(option == 6) {
			professorService
				.getStudentTaughtByProfessor()
				.forEach(logger::info);
		} else if(option == 8) {
			logger.info("Enter name, dob(YYYY-MM-DD) and gender (M/F)");
			
			Professor professor = (Professor) professorService.getUser();
			professor.setName(sc.next());
			professor.setDob(sc.next());
			professor.setGender("" + sc.next().charAt(0));
			int row = professorService.editUser(professor);
			logger.info("Row affected: " + row);
		} else if(option == 9) {
			Professor professor = (Professor) professorService.getUser();
			logger.info(professor);
		}
	}
}
