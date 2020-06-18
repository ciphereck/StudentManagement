package com.flipkart.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.flipkart.DAO.StudentRegistrationDAO;
import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.model.StudentRegistration;
import com.flipkart.utils.DBUtil;
import com.flipkart.utils.MySQLQuery;

/**
 * @author ciphereck
 * @category DAO Implementation
 *
 */
public class StudentRegistrationImpl implements StudentRegistrationDAO {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int addRegistrationDetails(StudentRegistration regData) throws SQLException {
		Connection conn = DBUtil.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.REGISTER_STUDENT);
		statement.setString(1, regData.getStudentUsername());
		statement.setString(2, regData.getRegId());
		statement.setInt(3, regData.getFees());
		statement.setString(4, regData.getTransactionId());
		statement.setString(5, regData.getPaymentModeId());
		
		return MySQLQuery.executeUpdate(statement);
	}
}
