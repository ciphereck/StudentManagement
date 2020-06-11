package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.flipkart.jdbc.LoginIdentityHelper;
import com.flipkart.utils.DBUtil;

public class UserDAOImpl implements UserDAO {
	private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

	@Override
	public String checkIdentity(String username, String password) {
		Connection conn = DBUtil.getConnection();
		
		ResultSet rs = (new LoginIdentityHelper(username, password)).executeQuery(conn);
		int count = 0;
		String typeOfUser = "";
		
		try {
			while(rs.next()) {
				typeOfUser = rs.getString("type");
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.fatal(e.getMessage());
		}
		
		
		return count==1 ? typeOfUser: "";
	}

}
