package com.flipkart.service;

import java.util.List;

import com.flipkart.DAO.StudentCourseDAO;
import com.flipkart.DAO.Impl.StudentCourseDAOImpl;
import com.flipkart.model.Catalogue;
import com.flipkart.model.Student;
import com.flipkart.model.User;

public class StudentService implements UserService {
	private final Student student;
	private final StudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl();
	
	public StudentService(Student student) {
		this.student = student;
	}
	
	public List<Catalogue> printStudentCourse() {
		return catalogueDAO.printCatalogueByStudentUsername(student.getUsername());
	}
	
	public void addStudentCourse(String courseId) {
		studentCourseDAO.addCourse(courseId, student.getUsername());
	}
	
	public void deleteStudentCourse(String courseId) {
		studentCourseDAO.deleteCourse(courseId, student.getUsername());
	}

	@Override
	public User getUser() {
		return student;
	}
}
