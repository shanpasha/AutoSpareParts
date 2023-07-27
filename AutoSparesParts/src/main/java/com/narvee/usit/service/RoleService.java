package com.narvee.usit.service;

import java.util.List;

import com.narvee.usit.model.Role;
public interface RoleService {

	
	public void addRole(Role role);
	public void deleteRole(Integer id);
	public List<Role> getAllRole();
	public void updateRole(Role role);
	public Role getByRoleId(Integer id);

}
