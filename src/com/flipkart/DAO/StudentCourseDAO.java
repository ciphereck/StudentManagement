package com.flipkart.DAO;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.model.StudentCourse;

/**
 * @author ciphereck
 * @category DAO Interface
 *
 */
public interface StudentCourseDAO {
	/**
	 * 
	 * @param studentCourse
	 * @return Add Course to Student Successfully
	 * @throws SQLException
	 */
	public int addCourseToStudentCourses(StudentCourse studentCourse) throws SQLException;
	
	/**
	 * 
	 * @param studentCourse
	 * @return Delete Course from Student Successfully
	 * @throws SQLException
	 */
	public int deleteCourse(StudentCourse studentCourse) throws SQLException;
	
	/**
	 * 
	 * @param studentCourse
	 * @return Updated Grade Successfully
	 * @throws SQLException
	 */
	public int updateGrade(StudentCourse studentCourse) throws SQLException;
	
	/**
	 * 
	 * @param studentCourse
	 * @return All Grades of specific student
	 * @throws SQLException
	 */
	public List<StudentCourse> getReportCard(StudentCourse studentCourse) throws SQLException;
}
