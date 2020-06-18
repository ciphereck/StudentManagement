package com.flipkart.service;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.DAO.StudentCourseDAO;
import com.flipkart.DAO.Impl.CourseDAOImpl;
import com.flipkart.DAO.Impl.StudentCourseDAOImpl;
import com.flipkart.model.Course;
import com.flipkart.model.StudentCourse;

/**
 * @author ciphereck
 * @category Service
 *
 */
public class Service {
	CourseDAOImpl courseDAO = new CourseDAOImpl();
	StudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl();
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Course> getAllCourses() throws SQLException {
		return courseDAO.getCourses();
	}
	
	/**
	 * 
	 * @param studentCourse
	 * @return
	 * @throws SQLException
	 */
	public List<StudentCourse> getReportCard(StudentCourse studentCourse) throws SQLException {
		return studentCourseDAO.getReportCard(studentCourse);
	}
}
