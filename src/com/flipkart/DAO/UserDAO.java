package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.exception.IllegalObjectException;
import com.flipkart.model.User;
import com.flipkart.utils.DBUtil;
import com.flipkart.utils.MySQLQuery;

/**
 * @author ciphereck
 * @category DAO Interface
 *
 */
public interface UserDAO {
	/**
	 * 
	 * @param role
	 * @param username
	 * @return User Details
	 * @throws SQLException
	 */
	default public User getUserDetail(String role, String username) throws SQLException {
		Connection conn = DBUtil.getConnection();
		User user = null;
		
		PreparedStatement statement = conn
				.prepareStatement(SqlQueryConstant
						.GET_USER_BY_ID.replace("$tableName", role.toLowerCase()+'s'));
		statement.setString(1, username);

		ResultSet rs = MySQLQuery.executeQuery(statement);
		while(rs!=null && rs.next()) {
			user = convertToUser(rs);
		}
		return user;
	}
	
	/**
	 * 
	 * @param role
	 * @return List of User by Roles
	 * @throws SQLException
	 */
	default public List<User> getUserByRole(String role) throws SQLException {
		List<User> users = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		
		PreparedStatement statement = conn
				.prepareStatement(SqlQueryConstant
						.GET_USER.replace("$tableName", role.toLowerCase()+'s'));
		
		ResultSet rs = MySQLQuery.executeQuery(statement);
		while(rs!=null && rs.next()) {
			users.add(convertToUser(rs));
		}
		
		return users;
	}
	
	/**
	 * 
	 * @param rs
	 * @return User from ResultSet
	 * @throws SQLException
	 */
	public User convertToUser(ResultSet rs) throws SQLException;
	
	/**
	 * 
	 * @param user
	 * @return Edited uSer Successfully
	 * @throws IllegalObjectException
	 * @throws SQLException
	 */
	default public int editUser(User user) throws IllegalObjectException, SQLException {
		Connection conn = DBUtil.getConnection();
		
		PreparedStatement statement;
		statement = getPreparedStatementForEditUser(user, conn);
				
		return MySQLQuery.executeUpdate(statement);
	}
	
	/**
	 * 
	 * @param user
	 * @param conn
	 * @return PreparedStatement from User
	 * @throws SQLException
	 * @throws IllegalObjectException
	 */
	public PreparedStatement getPreparedStatementForEditUser(User user, Connection conn) throws SQLException, IllegalObjectException;
	
}
