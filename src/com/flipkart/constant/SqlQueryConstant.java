package com.flipkart.constant;

public class SqlQueryConstant {
	public static final String AUTH_CRED_CHECK = "select type from credential where username=? and password=?";
	
	public static final String GET_CATALOGUE = "select * from catalogue";
	public static final String GET_COURSE_BY_STUDENT = "select * from catalogue where courseId IN (select courseId from studentCourses where studentUsername=?);";
	
	public static final String ADD_COURSE = "insert into studentCourses values(?, ?)";
}
