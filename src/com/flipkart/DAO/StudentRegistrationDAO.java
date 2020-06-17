package com.flipkart.DAO;

import java.sql.SQLException;

import com.flipkart.model.StudentRegistration;

public interface StudentRegistrationDAO {
	public int addRegistrationDetails(StudentRegistration regData) throws SQLException;
}
