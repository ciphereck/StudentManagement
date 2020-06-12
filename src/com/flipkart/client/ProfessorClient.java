package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.model.Professor;
import com.flipkart.model.Student;
import com.flipkart.service.ProfessorService;
import com.flipkart.service.Service;
import com.flipkart.service.StudentService;

public class ProfessorClient implements SubClient {
	private static final Logger logger = Logger.getLogger(StudentClient.class);
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
		if(option == 2) {
			professorService
				.printCatalogue()
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
		}
	}
}
