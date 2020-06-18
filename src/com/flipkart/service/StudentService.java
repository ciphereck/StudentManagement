package com.flipkart.service;

import java.util.List;

import com.flipkart.DAO.StudentCourseDAO;
import com.flipkart.DAO.StudentDAO;
import com.flipkart.DAO.StudentRegistrationDAO;
import com.flipkart.DAO.Impl.StudentCourseDAOImpl;
import com.flipkart.DAO.Impl.StudentDAOImpl;
import com.flipkart.DAO.Impl.StudentRegistrationImpl;
import com.flipkart.constant.Roles;
import com.flipkart.gateway.PaymentGateway;
import com.flipkart.gateway.RegistrationGateway;
import com.flipkart.model.Catalogue;
import com.flipkart.model.Student;
import com.flipkart.model.StudentRegistration;
import com.flipkart.model.User;

public class StudentService implements UserService {
	private Student student;
	private final StudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl();
	private final StudentRegistrationDAO studentRegistrationDAO = new StudentRegistrationImpl();
	private final StudentDAO studentDAO = new StudentDAOImpl();
	
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
		User user = studentDAO.getUserDetail(Roles.STUDENT.toString(), student.getUsername());
		if(user != null && user instanceof Student) {
			student = (Student) user;
		}
		return student;
	}
	
	public int calculateFees() {
		List<Catalogue> courses = printStudentCourse();
		if(courses.size() != 4) {
			return -1;
		}
		int amount = 0;
		for(Catalogue course : courses) {
			amount+= course.getFees();
		}
		
		return amount;
	}
	
	public int registerStudent() {
		int totalFees = calculateFees();
		if(totalFees == -1) {
			return -1;
		}
		String paymentId = (new PaymentGateway()).makePayment(totalFees);
		if(paymentId == PaymentGateway.FAILIURE_MESSAGE) {
			return -2;
		}
		String regId = (new RegistrationGateway())
				.register(student.getUsername(), totalFees);
		return studentRegistrationDAO.addRegistrationDetails(
				new StudentRegistration(student.getUsername(), 
						regId, totalFees, paymentId));
	}
	
	@Override
	public String getUsername() {
		return student.getUsername();
	}
}
