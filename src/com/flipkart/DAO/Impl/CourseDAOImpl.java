package com.flipkart.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.DAO.CourseDAO;
import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.model.Course;
import com.flipkart.model.ProfessorCourse;
import com.flipkart.model.StudentCourse;
import com.flipkart.utils.DBUtil;
import com.flipkart.utils.MySQLQuery;

public class CourseDAOImpl implements CourseDAO {
	@Override
	public List<Course> getCourses() throws SQLException {
		List<Course> courseList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.GET_COURSE);
		ResultSet rs = MySQLQuery.executeQuery(statement);
		
		while(rs!=null && rs.next()) {
			Course course = new Course();
			course.setCourseId(rs.getString("courseId"));
			course.setCourseName(rs.getString("courseName"));
			course.setFees(rs.getInt("fees"));
			course.setCredit(rs.getDouble("credit"));
			course.setCatalogueId(rs.getString("catalogueId"));

			courseList.add(course);
		}
		return courseList;
	}
	
	@Override
	public List<Course> getCourseEnrolledByStudent(String username) throws SQLException {
		List<Course> courseList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.GET_COURSE_BY_STUDENT);
		statement.setString(1, username);
		
		ResultSet rs = MySQLQuery.executeQuery(statement);
		while(rs != null && rs.next()) {
			StudentCourse course = new StudentCourse();
			course.setCourseId(rs.getString("courseId"));
			course.setCourseName(rs.getString("courseName"));
			course.setFees(rs.getInt("fees"));
			course.setCredit(rs.getDouble("credit"));
			course.setCatalogueId(rs.getString("catalogueId"));
			course.setTimestamp(rs.getString("timeOfLastUpdate"));
			course.setCatalogueId(rs.getString("catalogueId"));

			courseList.add(course);
		}
		return courseList;
	}

	@Override
	public List<ProfessorCourse> getCourseByProfessor(String username) throws SQLException {
		List<ProfessorCourse> courseList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.GET_COURSE_BY_PROFESSOR);
		statement.setString(1, username);
			
		ResultSet rs = MySQLQuery.executeQuery(statement);
		while(rs.next()) {
			ProfessorCourse course = new ProfessorCourse();
			
			course.setCourseId(rs.getString("courseId"));
			course.setCourseName(rs.getString("courseName"));
			course.setFees(rs.getInt("fees"));
			course.setCredit(rs.getDouble("credit"));
			course.setCatalogueId(rs.getString("catalogueId"));
			course.setTimestamp(rs.getString("timeOfLastUpdate"));
			
			courseList.add(course);
		}
		return courseList;
	}

	@Override
	public int addCourse(Course course) throws SQLException {
		Connection conn = DBUtil.getConnection();

		PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.ADD_COURSE);
		statement.setString(1, course.getCourseId());
		statement.setString(2, course.getCourseName());
		statement.setInt(3, course.getFees());
		statement.setDouble(4, course.getCredit());
		statement.setString(5, course.getCatalogueId());
		
		return MySQLQuery.executeUpdate(statement);
	}

	@Override
	public int editCourse(Course course) throws SQLException {
		Connection conn = DBUtil.getConnection();

		PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.UPDATE_COURSE);
		statement.setString(1, course.getCourseName());
		statement.setInt(2, course.getFees());
		statement.setDouble(3, course.getCredit());
		statement.setString(5, course.getCourseId());
		statement.setString(4, course.getCatalogueId());
		statement.setString(6, course.getCourseId());
		
		return MySQLQuery.executeUpdate(statement);
	}

	@Override
	public int deleteCourse(String courseId) throws SQLException {
		Connection conn = DBUtil.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.DELETE_COURSE);
		statement.setString(1, courseId);
		statement.setString(2, courseId);
			
		return MySQLQuery.executeUpdate(statement);
	}
}
