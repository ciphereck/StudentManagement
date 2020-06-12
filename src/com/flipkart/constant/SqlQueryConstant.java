package com.flipkart.constant;

public class SqlQueryConstant {
	public static final String AUTH_CRED_CHECK = "select type from credential where username=? and password=?";
	public static final String ADD_USER = "insert into credential values(?, ?, ?)";
	public static final String DELETE_USER = "delete from credential where username=?";
	public static final String GET_USER = "select username, type from credential order by type";
	
	public static final String GET_CATALOGUE = "select * from catalogue";
	public static final String GET_COURSE_BY_STUDENT = "select * from catalogue where courseId IN (select courseId from studentCourses where studentUsername=?);";
	public static final String GET_COURSE_BY_PROFESSOR = "select * from catalogue where courseId IN (select courseId from professorCourse where professorUsername=?)";
	
	public static final String ADD_SYUDENT_COURSE = "insert into studentCourses values(?, ?)";
	public static final String DELETE_STUDENT_COURSE = "delete from studentCourses where courseId=? and studentUsername=?";
	
	public static final String ADD_PROFESSOR_COURSE = "insert into professorCourse values(?, ?)";
	public static final String DELETE_PROFESSOR_COURSE = "delete from professorCourse where courseId=? and professorUsername=?";
}
