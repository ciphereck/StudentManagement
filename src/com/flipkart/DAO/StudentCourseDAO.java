package com.flipkart.DAO;

import java.util.List;

import com.flipkart.model.StudentCourse;

public interface StudentCourseDAO {
	public void addCourse(String courseId, String username);
	public void deleteCourse(String courseId, String username);
	public int updateGrade(String courseId, String grade, String username);
	public List<StudentCourse> getReportCard(String username);
}
