package com.flipkart.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.DAO.PaymentDAO;
import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.model.Payment;
import com.flipkart.utils.DBUtil;
import com.flipkart.utils.MySQLQuery;

/**
 * @author ciphereck
 * @category DAO Implementation
 *
 */
public class PaymentDAOImpl implements PaymentDAO {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Payment> getPaymentMode() throws SQLException {
		List<Payment> paymentList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.GET_PAYMENT_MODE);
		ResultSet rs = MySQLQuery.executeQuery(statement);
		
		while(rs!=null && rs.next()) {
			Payment payment = new Payment();
			payment.setPaymentModeId(rs.getString("paymentModeId"));
			payment.setPaymentMode(rs.getString("paymentMode"));
			
			paymentList.add(payment);
		}
		return paymentList;
	}
}
