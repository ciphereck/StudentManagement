package com.flipkart.service;

import com.flipkart.DAO.ProfessorCourseDAOImpl;
import com.flipkart.DAO.ProfessourCourseDAO;
import com.flipkart.model.Professor;

public class ProfessorService implements Service {
	private Professor professor;
	private ProfessourCourseDAO professorCourseDAO = new ProfessorCourseDAOImpl();
	
	public ProfessorService(Professor professor) {
		this.professor = professor;
	}
	
	public void addCouseToTeach(String courseId) {
		professorCourseDAO.addCourseToTeach(courseId, professor.getUsername());
	}
	
	public void deleteCourseToTeach(String courseId) {
		professorCourseDAO.deleteCourse(courseId, professor.getUsername());
	}
	
	public void viewCoursesToTeach() {
		catalogueDAO.printCatalogueByProfessorUsername(professor.getUsername());
	}
}
