package com.mbane.users.Reposity;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mbane.users.Entity.Roles;
import com.mbane.users.Entity.Users;

public interface RolesReposity extends JpaRepository<Roles, Long> {
	
	List<Roles> findRolesByStatusContains(String name);

	@Query("select r from Roles r where r.status= ?1")
	List<Roles> findRolesByStatus(String status);
	
	@Query("select r from Roles r where r.Id_roles= ?1")
	List<Roles> findRolesByRolesId(Long id);
	
	@Query("select r from Roles r")
	List<Roles> findByRoles(Roles role);
	
	@Query("select u from Roles u order by u.status DESC")
	List<Roles>findUsersByStatusDesc();
	
	@Query("select u from Roles u order by u.status ASC")
	List<Roles>findUsersByStatusAsc();

	@Query("select u from Users u")
	List<Users> findRolesByUsers();

}
