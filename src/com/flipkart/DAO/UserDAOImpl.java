package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.utils.DBUtil;

public class UserDAOImpl implements UserDAO {
	private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

	@Override
	public String checkIdentity(String username, String password) {
		Connection conn = DBUtil.getConnection();
		int count = 0;
		String typeOfUser = "";
		
		try {
			PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.AUTH_CRED_CHECK);
			statement.setString(1, username);
			statement.setString(2, password);
			
			ResultSet rs = MySQLQuery.executeQuery(conn, statement);
			
			try {
				while(rs.next()) {
					typeOfUser = rs.getString("type");
					count++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.fatal(e.getMessage());
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return count==1 ? typeOfUser: "";
	}

}
