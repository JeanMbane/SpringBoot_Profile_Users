package com.mbane.users.ServiceImplement;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbane.users.Entity.Roles;
import com.mbane.users.Entity.Users;
import com.mbane.users.Reposity.RolesReposity;
import com.mbane.users.ServiceInterface.RoleServiceInterface;

@Service
public class RoleServiceImplement implements RoleServiceInterface{

	@Autowired
	RolesReposity rolesReposity;
	
	@Override
	public Roles getRolesbyId(Long id) {
		// TODO Auto-generated method stub
		return rolesReposity.findById(id).get();
	}

	@Override
	public Roles saveRoles(Roles user) {
		// TODO Auto-generated method stub
		return rolesReposity.save(user);
	}

	@Override
	public Roles updatedRoles(Roles user) {
		// TODO Auto-generated method stub
		return rolesReposity.save(user);
	}

	@Override
	public void deleteRoles(Roles user) {
		rolesReposity.deleteAll();
		
	}

	@Override
	public void deleteRolesById(Long id) {
		rolesReposity.deleteById(id);
		
	}

	@Override
	public List<Roles> getAllRoles() {
		
		return rolesReposity.findAll();
	}

	@Override
	public List<Roles> findRolesByStatus(String status) {
		// TODO Auto-generated method stub
		return rolesReposity.findRolesByStatus(status);
	}

	@Override
	public List<Roles> findRolesByStatusContains(String Name) {
		
		return rolesReposity.findRolesByStatusContains(Name);
	}

	@Override
	public List<Roles> findByRoles(Roles role) {
		// TODO Auto-generated method stub
		return rolesReposity.findByRoles(role);
	}

	@Override
	public List<Roles> findRolesByRolesId(Long id) {
		// TODO Auto-generated method stub
		return rolesReposity.findRolesByRolesId(id);
	}

	@Override
	public List<Users> findRolesByUsers() {
		// TODO Auto-generated method stub
		return rolesReposity.findRolesByUsers();
	}
}
