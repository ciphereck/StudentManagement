package com.flipkart.service;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.DAO.ProfessourCourseDAO;
import com.flipkart.DAO.StudentCourseDAO;
import com.flipkart.DAO.StudentDAO;
import com.flipkart.DAO.Impl.ProfessorCourseDAOImpl;
import com.flipkart.DAO.Impl.StudentCourseDAOImpl;
import com.flipkart.DAO.Impl.StudentDAOImpl;
import com.flipkart.constant.Roles;
import com.flipkart.exception.IllegalRoleException;
import com.flipkart.exception.ProfessorNotTeachingCourseException;
import com.flipkart.exception.StudentNotFoundException;
import com.flipkart.exception.StudentRegistrationNotCompletedException;
import com.flipkart.model.Course;
import com.flipkart.model.ProfessorCourse;
import com.flipkart.model.Student;
import com.flipkart.model.StudentCourse;
import com.flipkart.model.User;

public class ProfessorService implements UserService {
	private ProfessourCourseDAO professorCourseDAO = new ProfessorCourseDAOImpl();
	private StudentDAO studentDAO = new StudentDAOImpl();
	private StudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl();
	
	public void addCouseToTeach(ProfessorCourse course) throws SQLException {
		professorCourseDAO.addCourseToTeach(course);
	}
	
	public void deleteCourseToTeach(ProfessorCourse course) throws SQLException {
		professorCourseDAO.deleteCourseToTeach(course);
	}
	
	public List<ProfessorCourse> getTeachingCourses(String username) throws SQLException {
		return catalogueDAO.getCourseByProfessor(username);
	}
	
	public int updateGrades(StudentCourse studentCourse, String profUsername) throws SQLException, IllegalRoleException, StudentNotFoundException, ProfessorNotTeachingCourseException, StudentRegistrationNotCompletedException {
		User user = getDetailByUsername(studentCourse.getStudentUsername(), Roles.STUDENT.toString());
		if(user == null) {
			throw new StudentNotFoundException(studentCourse.getStudentUsername());
		}
		
		long courseTeach = getTeachingCourses(profUsername)
			.stream()
			.filter(course -> course.getCourseId().equals(studentCourse.getCourseId()))
			.count();
		if(courseTeach == 0) {
			throw new ProfessorNotTeachingCourseException(studentCourse.getCourseId());
		}
			
		Student student = (Student) user;
		if(student.isRegistrationCompledted())
			return studentCourseDAO.updateGrade(studentCourse);
		else throw new StudentRegistrationNotCompletedException(studentCourse.getStudentUsername());
	}
	
	public List<Student> getStudentTaughtByProfessor(String username) throws SQLException {
		return studentDAO.getStudentByProfessor(username);
	}
}
