package com.flipkart.service;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.DAO.CourseDAO;
import com.flipkart.DAO.StudentCourseDAO;
import com.flipkart.DAO.StudentDAO;
import com.flipkart.DAO.StudentRegistrationDAO;
import com.flipkart.DAO.Impl.CourseDAOImpl;
import com.flipkart.DAO.Impl.StudentCourseDAOImpl;
import com.flipkart.DAO.Impl.StudentDAOImpl;
import com.flipkart.DAO.Impl.StudentRegistrationImpl;
import com.flipkart.constant.PaymentMode;
import com.flipkart.constant.Roles;
import com.flipkart.gateway.PaymentGateway;
import com.flipkart.gateway.RegistrationGateway;
import com.flipkart.model.Course;
import com.flipkart.model.Student;
import com.flipkart.model.StudentCourse;
import com.flipkart.model.StudentRegistration;
import com.flipkart.model.User;

public class StudentService extends UserService {
	private final StudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl();
	private final StudentRegistrationDAO studentRegistrationDAO = new StudentRegistrationImpl();
	private final StudentDAO studentDAO = new StudentDAOImpl();
	private final CourseDAO courseDAO = new CourseDAOImpl();
	
	public List<Course> getStudentCourse(String username) throws SQLException {
		return catalogueDAO.getCourseEnrolledByStudent(username);
	}
	
	public void addStudentCourse(StudentCourse studentCourse) throws SQLException {
		studentCourseDAO.addCourseToStudentCourses(studentCourse);
	}
	
	public void deleteStudentCourse(StudentCourse studentCourse) throws SQLException {
		studentCourseDAO.deleteCourse(studentCourse);
	}
	
	public int calculateFees(String username) throws SQLException {
		List<Course> courses = getStudentCourse(username);
		if(courses.size() != 4) {
			return -1;
		}
		int amount = 0;
		amount = courses
					.stream()
					.mapToInt(course -> (int)course.getFees())
					.sum();
		
		return amount;
	}
	
	public int registerStudent(String username) throws SQLException {
		int totalFees = calculateFees(username);
		if(totalFees == -1) {
			return -1;
		}
		String txId = (new PaymentGateway()).makePayment(totalFees);
		if(txId == PaymentGateway.FAILIURE_MESSAGE) {
			return -2;
		}
		String regId = (new RegistrationGateway())
				.register(username, totalFees);
		return studentRegistrationDAO.addRegistrationDetails(
				new StudentRegistration(username, 
						regId, totalFees, txId, PaymentMode.CREDIT_CARD.toString()));
	}
}
