package com.flipkart.client;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.DAO.CourseDAO;
import com.flipkart.DAO.Impl.CourseDAOImpl;
import com.flipkart.model.StudentCourse;
import com.flipkart.service.Service;

/**
 * @author ciphereck
 * @category Client
 *
 */
public interface SubClient {
	static final Logger subClientLogger = Logger.getLogger(SubClient.class);
	static final CourseDAO courseDAO = new CourseDAOImpl();
	static final Service service = new Service();
	static final Scanner sc = new Scanner(System.in);
	public void showMenu();
	
	/**
	 * 
	 * @param login
	 * @param type
	 */
	default public void showCurrentTime(boolean login, String type) { // 1 for login and 0 for logout
		LocalDateTime localDateTime = LocalDateTime.now();
		String dayOfWeek = localDateTime.getDayOfWeek().toString();
		String message = type + " Logged " + (login==true? "In" : "Out") + " on: " + dayOfWeek + " " + localDateTime;
		subClientLogger.info(message);
	}
	
	/**
	 * Show All Available Course
	 */
	default public void showAllCourses() {
		try {
			courseDAO
				.getCourses()
				.forEach(subClientLogger::info);
		} catch (SQLException e) {
			subClientLogger.error(e.getMessage());
		}
	}
	
	/**
	 * show report card of student
	 */
	default public void printReportCard() {
		subClientLogger.info("Enter username");
		String username = sc.next();
		StudentCourse course = new StudentCourse();
		course.setStudentUsername(username);
		printReportCard(course);
	}
	
	/**
	 * 
	 * @param course
	 */
	default public void printReportCard(StudentCourse course) {
		try {
			service
				.getReportCard(course)
				.forEach(subClientLogger::info);
		} catch (SQLException e) {
			subClientLogger.error(e.getMessage());
		}
	}
}
