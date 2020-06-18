package com.flipkart.DAO;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.model.Role;

public interface RoleDAO {
	public List<Role> getRoles() throws SQLException;
}
