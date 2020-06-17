package com.flipkart.DAO;

import java.sql.SQLException;

import com.flipkart.model.ProfessorCourse;

public interface ProfessourCourseDAO {
	public int addCourseToTeach(ProfessorCourse professorCourse) throws SQLException;
	public int deleteCourseToTeach(ProfessorCourse professorCourse) throws SQLException;
}
