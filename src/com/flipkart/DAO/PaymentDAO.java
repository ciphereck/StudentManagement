package com.flipkart.DAO;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.model.Payment;

public interface PaymentDAO {
	public List<Payment> getPaymentMode() throws SQLException;
}
