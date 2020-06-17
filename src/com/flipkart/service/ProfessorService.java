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
import com.flipkart.model.Course;
import com.flipkart.model.ProfessorCourse;
import com.flipkart.model.Student;
import com.flipkart.model.StudentCourse;
import com.flipkart.model.User;

public class ProfessorService extends UserService {
	private ProfessourCourseDAO professorCourseDAO = new ProfessorCourseDAOImpl();
	private StudentDAO studentDAO = new StudentDAOImpl();
	private StudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl();
	
	public void addCouseToTeach(ProfessorCourse course) throws SQLException {
		professorCourseDAO.addCourseToTeach(course);
	}
	
	public void deleteCourseToTeach(ProfessorCourse course) throws SQLException {
		professorCourseDAO.deleteCourseToTeach(course);
	}
	
	public List<Course> getTeachingCourses(String username) throws SQLException {
		return catalogueDAO.getCourseByProfessor(username);
	}
	
	public int updateGrades(StudentCourse studentCourse, String profUsername) throws SQLException, IllegalRoleException {
		User user = getDetailByUsername(studentCourse.getStudentUsername(), Roles.STUDENT.toString());
		if(user == null) {
			return -1;
		}
		
		long courseTeach = getTeachingCourses(profUsername)
			.stream()
			.filter(course -> course.getCourseId().equals(studentCourse.getCourseId()))
			.count();
		if(courseTeach == 0) {
			return -3;
		}
			
		Student student = (Student) user;
		if(student.isRegistrationCompledted())
			return studentCourseDAO.updateGrade(studentCourse);
		else return -2;
	}
	
	public List<Student> getStudentTaughtByProfessor(String username) throws SQLException {
		return studentDAO.getStudentByProfessor(username);
	}
}
