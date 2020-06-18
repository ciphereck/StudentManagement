package com.flipkart.DAO;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.model.Payment;

/**
 * @author ciphereck
 * @category DAO Interface
 *
 */
public interface PaymentDAO {
	/**
	 * 
	 * @return All Payment Modes
	 * @throws SQLException
	 */
	public List<Payment> getPaymentMode() throws SQLException;
}
