package com.flipkart.constant;

public class SqlQueryConstant {
	public static final String AUTH_CHECK_USERS = "select role from users where username=? and password=?";
	public static final String ADD_USER = "insert into users values(?, ?, ?)";
	public static final String DELETE_USER = "delete from users where username=?";
	
	public static final String GET_COURSE = "select * from courses";
	public static final String GET_COURSE_BY_STUDENT = "select courses.*, studentCourses.timeofLastUpdate from courses, studentCourses where courses.courseId IN (select courseId from studentCourses where studentUsername=?) and studentUsername=? and studentCourses.courseId = courses.courseId;";
	public static final String GET_COURSE_BY_PROFESSOR = "select * from courses where courseId IN (select courseId from professorCourses where professorUsername=?)";
	public static final String DELETE_COURSE = "delete from courses where courseId=? and (? not in (select courseId from studentCourses))";
	public static final String ADD_COURSE = "insert into courses values(?, ?, ?, ?, ?)";
	public static final String UPDATE_COURSE = "update courses set courseName=?, fees=?, credit=?, catalogueId=? where courseId=? and (? not in (select courseId from studentCourses))";
	
	public static final String ADD_SYUDENT_COURSE = "insert into studentCourses (courseId, studentUsername) values(?, ?)";
	public static final String DELETE_STUDENT_COURSE = "delete from studentCourses where courseId=? and studentUsername=?";
	public static final String UPDATE_STUDENT_GRADE = "update studentCourses set grades = ? where studentUsername=? and courseId=?";
	public static final String GET_GRADES_BY_STUDENT = "select * from studentCourses where studentUsername=?";
	
	
	public static final String ADD_PROFESSOR_COURSE = "insert into professorCourses (courseId, professorusername) values(?, ?)";
	public static final String DELETE_PROFESSOR_COURSE = "delete from professorCourses where courseId=? and professorUsername=?";
	
	public static final String GET_USER = "select * from $tableName";
	public static final String GET_USER_BY_ID = "select * from $tableName where username=?";
	
	public static final String UPDATE_STUDENT = "update students set name=?, dob=?, gender=? where username=?";
	public static final String UPDATE_PROFESSOR = "update professors set name=?, dob=?, gender=? where username=?";
	public static final String UPDATE_ADMIN = "update admins set name=?, dob=?, gender=? where username=?";
	
	public static final String GET_STUDENT_LIST_FOR_PROFESSOR = "select * from students where username in (select studentUsername from studentCourses where courseId in (select courseId from professorCourses where professorUsername=?))";
	
	public static final String REGISTER_STUDENT = "insert into registrations (studentUsername, regId, feesPaid, paymentId, paymentModeId) values(?, ?, ?, ?, ?);";
}
