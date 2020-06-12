package com.flipkart.DAO;

public interface ProfessourCourseDAO {
	public void addCourseToTeach(String courseId, String username);
	public void deleteCourse(String courseId, String username);
}
