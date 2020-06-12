package com.flipkart.service;

import java.util.List;

import com.flipkart.DAO.ProfessourCourseDAO;
import com.flipkart.DAO.Impl.ProfessorCourseDAOImpl;
import com.flipkart.model.Catalogue;
import com.flipkart.model.Professor;

public class ProfessorService implements UserService {
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
	
	public List<Catalogue> viewCoursesToTeach() {
		return catalogueDAO.printCatalogueByProfessorUsername(professor.getUsername());
	}
}
