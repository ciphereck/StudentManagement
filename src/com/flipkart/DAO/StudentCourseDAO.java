package com.flipkart.DAO;

public interface StudentCourseDAO {
	public void addCourse(String courseId, String username);
	public void deleteCourse(String courseId, String username);
	public int updateGrade(String courseId, String grade, String username);
}
