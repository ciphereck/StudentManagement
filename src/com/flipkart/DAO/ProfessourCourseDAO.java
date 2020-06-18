package com.flipkart.DAO;

import java.sql.SQLException;

import com.flipkart.model.ProfessorCourse;

/**
 * @author ciphereck
 * @category DAO Interface
 *
 */
public interface ProfessourCourseDAO {
	/**
	 * 
	 * @param professorCourse
	 * @return Course Added for Professor Successfully
	 * @throws SQLException
	 */
	public int addCourseToTeach(ProfessorCourse professorCourse) throws SQLException;
	
	/**
	 * 
	 * @param professorCourse
	 * @return Course Deleted for Professor Successfully
	 * @throws SQLException
	 */
	public int deleteCourseToTeach(ProfessorCourse professorCourse) throws SQLException;
}
