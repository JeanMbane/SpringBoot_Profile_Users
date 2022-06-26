package com.mbane.users.ServiceInterface;

import java.util.List;


import com.mbane.users.Entity.Roles;
import com.mbane.users.Entity.Users;


public interface RoleServiceInterface {
	

	Roles getRolesbyId(Long id);
	Roles saveRoles(Roles user);
	Roles updatedRoles(Roles user);
	void deleteRoles(Roles user);
	void deleteRolesById(Long id);
	List<Roles>getAllRoles();
	 
	 List<Roles>findRolesByStatus(String status);
	 List<Roles>findRolesByStatusContains(String Name);
	 List<Roles>findByRoles(Roles role);
	 List<Roles>findRolesByRolesId(Long id);
	 List<Users> findRolesByUsers();
}


