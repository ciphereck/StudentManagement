package com.flipkart.DAO;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.model.Course;
import com.flipkart.model.ProfessorCourse;

public interface CourseDAO {
	public List<Course> getCourses() throws SQLException;
	public List<Course> getCourseEnrolledByStudent(String username) throws SQLException;
	public List<ProfessorCourse> getCourseByProfessor(String username) throws SQLException;
	
	public int addCourse(Course course) throws SQLException;
	public int editCourse(Course course) throws SQLException;
	public int deleteCourse(String catalogue) throws SQLException;
}
