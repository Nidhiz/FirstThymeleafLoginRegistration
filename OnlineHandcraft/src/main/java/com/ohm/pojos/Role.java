package com.ohm.pojos;

import javax.persistence.*;

@Entity
@Table(name="Roles")
public class Role {

	@Id
	@Column(name = "roleid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long roleId;
	@Column(name = "rolename")
	private String roleName;
	@Column(name = "status")
	private String roleStatus;
	
	public Role() {
		System.out.println("in ctor of "+getClass().getName());
	}

	
	
	public Role(Long roleId, String roleName, String roleStatus) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleStatus = roleStatus;
	}



	public Role(String rolename) {
		this.roleName=rolename;
	}



	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleStatus() {
		return roleStatus;
	}
	public void setRoleStatus(String roleStatus) {
		this.roleStatus = roleStatus;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleStatus=" + roleStatus + "]";
	}
	
	
}
