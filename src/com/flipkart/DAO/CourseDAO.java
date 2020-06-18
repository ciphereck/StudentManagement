package com.flipkart.DAO;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.model.Course;
import com.flipkart.model.ProfessorCourse;

/**
 * @author ciphereck
 * @category DAO Interface
 *
 */
public interface CourseDAO {
	/**
	 * 
	 * @return All Course
	 * @throws SQLException
	 */
	public List<Course> getCourses() throws SQLException;
	
	/**
	 * 
	 * @param username
	 * @return Course By Student
	 * @throws SQLException
	 */
	public List<Course> getCourseEnrolledByStudent(String username) throws SQLException;
	
	/**
	 * 
	 * @param username
	 * @return Course By Professor
	 * @throws SQLException
	 */
	public List<ProfessorCourse> getCourseByProfessor(String username) throws SQLException;
	
	/**
	 * 
	 * @param course
	 * @return Course Added Successfully
	 * @throws SQLException
	 */
	public int addCourse(Course course) throws SQLException;
	
	/**
	 * 
	 * @param course
	 * @return Course Added Successfully
	 * @throws SQLException
	 */
	public int editCourse(Course course) throws SQLException;
	
	/**
	 * 
	 * @param catalogue
	 * @return Course deleted Successfully
	 * @throws SQLException
	 */
	public int deleteCourse(String catalogue) throws SQLException;
}
