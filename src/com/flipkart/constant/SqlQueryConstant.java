package com.flipkart.constant;

/**
 * @author ciphereck
 * @category Constant
 *
 */
public class SqlQueryConstant {
	public static final String AUTH_CHECK_USERS = "select role from users where username=? and password=?";
	public static final String ADD_USER = "insert into users (username, password, role) values(?, ?, ?)";
	public static final String DELETE_USER = "delete from users where username=?";
	
	public static final String GET_ROLE = "select * from roles";
	
	public static final String GET_PAYMENT_MODE = "select * from payments";
	
	public static final String GET_COURSE = "select * from courses";
	public static final String GET_COURSE_BY_STUDENT = "select courses.*, studentCourses.studentUsername, studentCourses.timeOfLastUpdate from courses inner join  studentCourses on courses.courseId=studentCourses.courseId where studentUsername=?;";
	public static final String GET_COURSE_BY_PROFESSOR = "select courses.*, professorCourses.timeOfLastUpdate from courses inner join professorCourses on courses.courseId=professorCourses.courseId where professorUsername=?;";
	public static final String DELETE_COURSE = "delete from courses where courseId=? and (? not in (select courseId from studentCourses))";
	public static final String ADD_COURSE = "insert into courses (courseId, courseName, fees, credit, catalogueId) values(?, ?, ?, ?, ?)";
	public static final String UPDATE_COURSE = "update courses set courseName=?, fees=?, credit=?, catalogueId=? where courseId=? and (? not in (select courseId from studentCourses))";
	
	public static final String ADD_SYUDENT_COURSE = "insert into studentCourses (courseId, studentUsername) values(?, ?)";
	public static final String DELETE_STUDENT_COURSE = "delete from studentCourses where courseId=? and studentUsername=?";
	public static final String UPDATE_STUDENT_GRADE = "update studentCourses set grades = ? where studentUsername=? and courseId=?";
	public static final String GET_GRADES_BY_STUDENT = "select * from courses inner join studentCourses on courses.courseId=studentCourses.courseId where studentUsername=?;";
	
	
	public static final String ADD_PROFESSOR_COURSE = "insert into professorCourses (courseId, professorusername) values(?, ?)";
	public static final String DELETE_PROFESSOR_COURSE = "delete from professorCourses where courseId=? and professorUsername=?";
	
	public static final String GET_USER = "select * from $tableName";
	public static final String GET_USER_BY_ID = "select * from $tableName where username=?";
	
	public static final String UPDATE_STUDENT = "update students set name=?, dob=?, gender=? where username=?";
	public static final String UPDATE_PROFESSOR = "update professors set name=?, dob=?, gender=? where username=?";
	public static final String UPDATE_ADMIN = "update admins set name=?, dob=?, gender=? where username=?";
	
	public static final String GET_STUDENT_LIST_FOR_PROFESSOR = "select students.* from students inner join studentCourses on students.username=studentCourses.studentUsername inner join professorCourses on studentCourses.courseId=professorCourses.courseId where professorCourses.professorUsername=? group by username;";
	
	public static final String REGISTER_STUDENT = "insert into registrations (studentUsername, regId, feesPaid, transactionId, paymentModeId) values(?, ?, ?, ?, ?);";
}
