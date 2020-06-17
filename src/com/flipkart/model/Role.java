package com.flipkart.model;

public class Role {
	String roleId;
	String roleName;
	String roleDescription;
	
	/**
	 * @param roleId
	 * @param roleName
	 * @param roleDescription
	 */
	public Role(String roleId, String roleName, String roleDescription) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
	}

	/**
	 * 
	 */
	public Role() {
		super();
	}

	/**
	 * @return the roleId
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the roleDescription
	 */
	public String getRoleDescription() {
		return roleDescription;
	}

	/**
	 * @param roleDescription the roleDescription to set
	 */
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	@Override
	public String toString() {
		return "Role [" + (roleId != null ? "roleId=" + roleId + ", " : "")
				+ (roleName != null ? "roleName=" + roleName + ", " : "")
				+ (roleDescription != null ? "roleDescription=" + roleDescription : "") + "]";
	}
}
