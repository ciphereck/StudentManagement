package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.model.User;
import com.flipkart.utils.DBUtil;
import com.flipkart.utils.MySQLQuery;

public interface UserDAO {
	Logger logger = Logger.getLogger(UserDAO.class);
	
	default public List<User> printUserByType(String role) {
		List<User> users = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		
		try {
			PreparedStatement statement = conn
					.prepareStatement(SqlQueryConstant
							.GET_USER.replace("$tableName", role.toLowerCase()));
			
			ResultSet rs = MySQLQuery.executeQuery(statement);
			while(rs.next()) {
				users.add(convertToUser(rs));
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		
		return users;
	}
	
	public User convertToUser(ResultSet rs);
	
	default public int editUser(User user) {
		Connection conn = DBUtil.getConnection();
		int row = 0;
		
		PreparedStatement statement;
		try {
			statement = getPreparedStatementForEditUser(user, conn);
			if(statement != null)
				return MySQLQuery.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public PreparedStatement getPreparedStatementForEditUser(User user, Connection conn) throws SQLException;
	
}
