package com.flipkart.DAO;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.model.Role;

/**
 * @author ciphereck
 * @category DAO Interface
 *
 */
public interface RoleDAO {
	/**
	 * 
	 * @return List of All Roles
	 * @throws SQLException
	 */
	public List<Role> getRoles() throws SQLException;
}
