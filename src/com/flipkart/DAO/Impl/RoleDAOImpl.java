package com.flipkart.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.DAO.RoleDAO;
import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.model.Course;
import com.flipkart.model.Role;
import com.flipkart.utils.DBUtil;
import com.flipkart.utils.MySQLQuery;

/**
 * @author ciphereck
 * @category DAO Implementation
 *
 */
public class RoleDAOImpl implements RoleDAO {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Role> getRoles() throws SQLException {
		List<Role> roleList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.GET_ROLE);
		ResultSet rs = MySQLQuery.executeQuery(statement);
		
		while(rs!=null && rs.next()) {
			Role role = new Role();
			role.setRoleId(rs.getString("roleId"));
			role.setRoleName(rs.getString("roleName"));
			role.setRoleDescription(rs.getString("roleDescription"));
			
			roleList.add(role);
		}
		return roleList;
	}
	
}
