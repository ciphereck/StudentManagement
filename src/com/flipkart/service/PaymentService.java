package com.flipkart.service;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.DAO.PaymentDAO;
import com.flipkart.DAO.Impl.PaymentDAOImpl;
import com.flipkart.model.Payment;

/**
 * @author ciphereck
 * @category Service
 *
 */
public class PaymentService {
	PaymentDAO paymentDAO = new PaymentDAOImpl();
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Payment> getPaymentMode() throws SQLException {
		return paymentDAO.getPaymentMode();
	}
}
