package com.flipkart.service;

import java.util.List;

import com.flipkart.DAO.ProfessorDAO;
import com.flipkart.DAO.ProfessourCourseDAO;
import com.flipkart.DAO.StudentCourseDAO;
import com.flipkart.DAO.StudentDAO;
import com.flipkart.DAO.Impl.ProfessorCourseDAOImpl;
import com.flipkart.DAO.Impl.ProfessorDAOImpl;
import com.flipkart.DAO.Impl.StudentCourseDAOImpl;
import com.flipkart.DAO.Impl.StudentDAOImpl;
import com.flipkart.constant.Roles;
import com.flipkart.model.Course;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;
import com.flipkart.model.User;

public class ProfessorService implements UserService {
	private Professor professor;
	private ProfessourCourseDAO professorCourseDAO = new ProfessorCourseDAOImpl();
	private ProfessorDAO professorDAO = new ProfessorDAOImpl();
	private StudentDAO studentDAO = new StudentDAOImpl();
	private StudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl();
	
	public ProfessorService(Professor professor) {
		this.professor = professor;
	}
	
	public void addCouseToTeach(String courseId) {
		professorCourseDAO.addCourseToTeach(courseId, professor.getUsername());
	}
	
	public void deleteCourseToTeach(String courseId) {
		professorCourseDAO.deleteCourse(courseId, professor.getUsername());
	}
	
	public List<Course> viewCoursesToTeach() {
		return catalogueDAO.getCourseByProfessor(professor.getUsername());
	}

	@Override
	public User getUser() {
		User user = professorDAO.getUserDetail(Roles.PROFESSOR.toString(), professor.getUsername());
		if(user != null && user instanceof Professor) {
			professor = (Professor) user;
		}
		return professor;
	}
	
	public int updateGrades(String courseId, String username, String grade) {
		User user = getDetailByUsername(username, Roles.STUDENT.toString());
		if(user == null) {
			return -1;
		}
		
		long courseTeach = viewCoursesToTeach()
			.stream()
			.filter(course -> course.getCourseId().equals(courseId))
			.count();
		if(courseTeach == 0) {
			return -3;
		}
			
		Student student = (Student) user;
		if(student.getPayment() == 1)
			return studentCourseDAO.updateGrade(courseId, grade, student.getUsername());
		else return -2;
	}
	
	@Override
	public String getUsername() {
		return professor.getUsername();
	}
	
	public List<Student> getStudentTaughtByProfessor() {
		return studentDAO.getStudentByProfessor(professor.getUsername());
	}
}
