package com.flipkart.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.DAO.StudentCourseDAO;
import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.model.StudentCourse;
import com.flipkart.utils.DBUtil;
import com.flipkart.utils.MySQLQuery;

/**
 * @author ciphereck
 * @category DAO Implementation
 *
 */
public class StudentCourseDAOImpl implements StudentCourseDAO {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int addCourseToStudentCourses(StudentCourse studentCourse) throws SQLException {
		Connection conn = DBUtil.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.ADD_SYUDENT_COURSE);
		statement.setString(1, studentCourse.getCourseId());
		statement.setString(2, studentCourse.getStudentUsername());
		
		return MySQLQuery.executeUpdate(statement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int deleteCourse(StudentCourse studentCourse) throws SQLException {
		Connection conn = DBUtil.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.DELETE_STUDENT_COURSE);
		statement.setString(1, studentCourse.getCourseId());
		statement.setString(2, studentCourse.getStudentUsername());
		
		return MySQLQuery.executeUpdate(statement);
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int updateGrade(StudentCourse studentCourse) throws SQLException {
		Connection conn = DBUtil.getConnection();
			
		PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.UPDATE_STUDENT_GRADE);
		statement.setString(1, studentCourse.getGrade());
		statement.setString(2, studentCourse.getStudentUsername());
		statement.setString(3, studentCourse.getCourseId());
		
		return MySQLQuery.executeUpdate(statement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<StudentCourse> getReportCard(StudentCourse course) throws SQLException {
		List<StudentCourse> courseList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.GET_GRADES_BY_STUDENT);
		statement.setString(1, course.getStudentUsername());
		
		ResultSet rs = MySQLQuery.executeQuery(statement);
		while(rs!=null && rs.next()) {
			StudentCourse studentCourse = new StudentCourse();
			
			studentCourse.setCourseId(rs.getString("courseId"));
			studentCourse.setGrade(rs.getString("grades"));
			studentCourse.setCourseId(studentCourse.getStudentUsername());
			studentCourse.setCourseName(rs.getString("courseName"));
			studentCourse.setCredit(rs.getDouble("credit"));
			studentCourse.setFees(rs.getInt("credit"));

			courseList.add(studentCourse);
		}
		
		return courseList;
	}
	
	
}
