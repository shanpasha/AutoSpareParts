package com.narvee.usit.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narvee.usit.model.Role;
import com.narvee.usit.repository.RoleRepository;
import com.narvee.usit.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository rolerepo;

	@Override
	public void addRole(Role role) {
		rolerepo.save(role);
	}

	@Override
	public void deleteRole(Integer id) {
		rolerepo.deleteById(id);
	}

	@Override
	public List<Role> getAllRole() {

		return rolerepo.findAll();
	}

	@Override
	public void updateRole(Role role) {
		rolerepo.save(role);

	}

	@Override
	public Role getByRoleId(Integer id) {
		return rolerepo.findById(id).get();
	}

}
