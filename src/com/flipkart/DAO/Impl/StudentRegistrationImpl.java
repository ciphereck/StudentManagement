package com.flipkart.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.flipkart.DAO.StudentRegistrationDAO;
import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.model.StudentRegistration;
import com.flipkart.utils.DBUtil;
import com.flipkart.utils.MySQLQuery;

public class StudentRegistrationImpl implements StudentRegistrationDAO {
	Logger logger = Logger.getLogger(StudentCourseDAOImpl.class);
	
	@Override
	public int addRegistrationDetails(StudentRegistration regData) {
		Connection conn = DBUtil.getConnection();
		int row = 0;
		try {
			PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.REGISTER_STUDENT);
			statement.setString(1, regData.getStudentUsername());
			statement.setString(2, regData.getRegId());
			statement.setInt(3, regData.getFees());
			statement.setString(4, regData.getPaymentId());
			statement.setString(5, regData.getPaymentModeId());
			
			row = MySQLQuery.executeUpdate(statement);
			logger.info("Row affected: " + row);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return row;
	}
	
}
