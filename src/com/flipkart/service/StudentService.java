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
import com.flipkart.exception.PaymentFailedException;
import com.flipkart.exception.PaymentSucceedRegistrationFailedException;
import com.flipkart.exception.WrongNoOfCourseException;
import com.flipkart.gateway.PaymentGateway;
import com.flipkart.gateway.RegistrationGateway;
import com.flipkart.model.Course;
import com.flipkart.model.Student;
import com.flipkart.model.StudentCourse;
import com.flipkart.model.StudentRegistration;
import com.flipkart.model.User;

public class StudentService implements UserService {
	private final StudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl();
	private final StudentRegistrationDAO studentRegistrationDAO = new StudentRegistrationImpl();
	
	public List<Course> getStudentCourse(String username) throws SQLException {
		return catalogueDAO.getCourseEnrolledByStudent(username);
	}
	
	public void addStudentCourse(StudentCourse studentCourse) throws SQLException {
		studentCourseDAO.addCourseToStudentCourses(studentCourse);
	}
	
	public void deleteStudentCourse(StudentCourse studentCourse) throws SQLException {
		studentCourseDAO.deleteCourse(studentCourse);
	}
	
	public int calculateFees(String username) throws SQLException, WrongNoOfCourseException {
		List<Course> courses = getStudentCourse(username);
		if(courses.size() != 4) {
			throw new WrongNoOfCourseException(courses.size());
		}
		int amount = 0;
		amount = courses
					.stream()
					.mapToInt(course -> (int)course.getFees())
					.sum();
		
		return amount;
	}
	
	public int registerStudent(String username) throws SQLException, WrongNoOfCourseException, PaymentFailedException, PaymentSucceedRegistrationFailedException {
		int totalFees = calculateFees(username);
		
		String txId = (new PaymentGateway()).makePayment(totalFees);
		
		String regId = (new RegistrationGateway())
				.register(username, totalFees);
		int row = studentRegistrationDAO.addRegistrationDetails(
				new StudentRegistration(username, 
						regId, totalFees, txId, PaymentMode.CREDIT_CARD.toString()));
		if(row == 0) {
			throw new PaymentSucceedRegistrationFailedException();
		}
		return row;
	}
}
