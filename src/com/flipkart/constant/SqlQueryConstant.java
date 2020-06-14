package com.flipkart.constant;

public class SqlQueryConstant {
	public static final String AUTH_CRED_CHECK = "select role from credentials where username=? and password=?";
	public static final String ADD_USER_CREDENTIAL = "insert into credentials values(?, ?, ?)";
	public static final String DELETE_USER_CREDENTIAL = "delete from credentials where username=?";
	public static final String GET_USER_CREDENTIAL = "select username, type from credentials order by role";
	
	public static final String GET_CATALOGUE = "select * from catalogues";
	public static final String GET_COURSE_BY_STUDENT = "select catalogues.*, studentCourses.timeofLastUpdate from catalogues, studentCourses where catalogues.courseId IN (select courseId from studentCourses where studentUsername=?) and studentUsername=? and studentCourses.courseId = catalogues.courseId;";
	public static final String GET_COURSE_BY_PROFESSOR = "select * from catalogues where courseId IN (select courseId from professorCourses where professorUsername=?)";
	
	public static final String ADD_SYUDENT_COURSE = "insert into studentCourses values(?, ?, ?)";
	public static final String DELETE_STUDENT_COURSE = "delete from studentCourses where courseId=? and studentUsername=?";
	
	public static final String ADD_PROFESSOR_COURSE = "insert into professorCourses values(?, ?)";
	public static final String DELETE_PROFESSOR_COURSE = "delete from professorCourses where courseId=? and professorUsername=?";
	
	public static final String GET_USER = "select * from $tableName";
	public static final String ADD_USER = "insert into $tableName (username) values(?)";
	
	public static final String UPDATE_STUDENT = "update students set name=?, dob=?, gender=? where username=?";
	public static final String UPDATE_PROFESSOR = "update professors set name=?, dob=?, gender=? where username=?";
	public static final String UPDATE_ADMIN = "update admins set name=?, dob=?, gender=? where username=?";
}
