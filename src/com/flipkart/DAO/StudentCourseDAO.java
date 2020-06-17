package com.flipkart.DAO;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.model.StudentCourse;

public interface StudentCourseDAO {
	public int addCourseToStudentCourses(StudentCourse studentCourse) throws SQLException;
	public int deleteCourse(StudentCourse studentCourse) throws SQLException;
	public int updateGrade(StudentCourse studentCourse) throws SQLException;
	public List<StudentCourse> getReportCard(StudentCourse studentCourse) throws SQLException;
}
