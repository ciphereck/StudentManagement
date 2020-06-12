package com.flipkart.constant;

public class SqlQueryConstant {
	public static final String AUTH_CRED_CHECK = "select type from credential where username=? and password=?";
	public static final String ADD_USER_CREDENTIAL = "insert into credential values(?, ?, ?)";
	public static final String DELETE_USER_CREDENTIAL = "delete from credential where username=?";
	public static final String GET_USER_CREDENTIAL = "select username, type from credential order by type";
	
	public static final String GET_CATALOGUE = "select * from catalogue";
	public static final String GET_COURSE_BY_STUDENT = "select catalogue.*, studentCourses.timeofLastUpdate from catalogue, studentCourses where catalogue.courseId IN (select courseId from studentCourses where studentUsername=?) and studentUserName=? and studentCourses.courseId = catalogue.courseId;";
	public static final String GET_COURSE_BY_PROFESSOR = "select * from catalogue where courseId IN (select courseId from professorCourse where professorUsername=?)";
	
	public static final String ADD_SYUDENT_COURSE = "insert into studentCourses values(?, ?, ?)";
	public static final String DELETE_STUDENT_COURSE = "delete from studentCourses where courseId=? and studentUsername=?";
	
	public static final String ADD_PROFESSOR_COURSE = "insert into professorCourse values(?, ?)";
	public static final String DELETE_PROFESSOR_COURSE = "delete from professorCourse where courseId=? and professorUsername=?";
	
	public static final String GET_USER = "select * from $tableName";
}
