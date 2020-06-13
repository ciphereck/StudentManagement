package com.flipkart.DAO.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.DAO.AdminDAO;
import com.flipkart.model.Admin;
import com.flipkart.model.User;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public User convertToUser(ResultSet rs) {
		Admin admin = null;
		try {
			String username = rs.getString("username");
			String name = rs.getString("name");
			String genderString = rs.getString("gender");
			char gender = 0;
			if(genderString != null) {
				gender = genderString.charAt(0);
			}
			String dob = rs.getString("dob");
			
			admin = new Admin(username, name, dob, gender);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
	}
	
}
