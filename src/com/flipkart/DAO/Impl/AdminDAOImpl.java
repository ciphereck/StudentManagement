package com.flipkart.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.DAO.AdminDAO;
import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.exception.IllegalObjectException;
import com.flipkart.model.Admin;
import com.flipkart.model.User;

/**
 * @author ciphereck
 * @category DAO Implementation
 *
 */
public class AdminDAOImpl implements AdminDAO {
	@Override
	public User convertToUser(ResultSet rs) throws SQLException {
		Admin admin = new Admin();
		
		admin.setUsername(rs.getString("username"));
		admin.setName(rs.getString("name"));
		admin.setGender(rs.getString("gender"));
		admin.setDob(rs.getString("dob"));
		
		return admin;
	}

	@Override
	public PreparedStatement getPreparedStatementForEditUser(User user, Connection conn) throws SQLException, IllegalObjectException {
		if(!(user instanceof Admin)) {
			throw new IllegalObjectException(Admin.class.getClass().getName(), user.getClass().getName());
		}
		
		Admin admin = (Admin) user;
		PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.UPDATE_ADMIN);
		statement.setString(1, admin.getName());
		statement.setString(2, admin.getDob());
		statement.setString(3, admin.getGender());
		statement.setString(4, admin.getUsername());
		return statement;
	}	
}
