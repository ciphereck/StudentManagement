package com.flipkart.service;

import com.flipkart.DAO.CatalogueDAO;
import com.flipkart.DAO.CatalogueDAOImpl;
import com.flipkart.DAO.StudentCourseDAO;
import com.flipkart.DAO.StudentCourseDAOImpl;
import com.flipkart.model.Student;

public class StudentService implements Service {
	private final Student student;
	private final CatalogueDAO catalogueDAO = new CatalogueDAOImpl();
	private final StudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl();
	
	public StudentService(Student student) {
		this.student = student;
	}
	
	public void printCatalogue() {
		catalogueDAO.printCatalogue();
	}
	
	public void printStudentCourse() {
		catalogueDAO.printCatalogueByStudentUsername(student.getUsername());
	}
	
	public void addStudentCourse(String courseId) {
		studentCourseDAO.addCourse(courseId, student.getUsername());
	}
	
}
