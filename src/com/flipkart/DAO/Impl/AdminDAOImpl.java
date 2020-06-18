package com.flipkart.DAO.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.DAO.AdminDAO;
import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.model.Admin;
import com.flipkart.model.User;
import com.mysql.jdbc.Connection;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public User convertToUser(ResultSet rs) {
		Admin admin = null;
		try {
			String username = rs.getString("username");
			String name = rs.getString("name");
			String gender = rs.getString("gender");
			String dob = rs.getString("dob");
			
			admin = new Admin(username, name, dob, gender);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
	}

	@Override
	public PreparedStatement getPreparedStatementForEditUser(User user, java.sql.Connection conn) throws SQLException {
		Admin admin = (Admin) user;
		PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.UPDATE_ADMIN);
		statement.setString(1, admin.getName());
		statement.setString(2, admin.getDob());
		statement.setString(3, "" + admin.getGender());
		statement.setString(4, admin.getUsername());
		return statement;
	}
	
}
