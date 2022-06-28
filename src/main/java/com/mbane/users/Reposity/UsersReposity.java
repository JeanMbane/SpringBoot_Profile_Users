package com.mbane.users.Reposity;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mbane.users.Entity.Roles;
import com.mbane.users.Entity.Users;

@RepositoryRestResource(path="rest")
public interface UsersReposity extends JpaRepository<Users, Long>{	
	
	

	Users findUsersByName(String na);
	
	@Query("select u from Users u where u.password like %?1")
	Users findUsersByPassword(String password);
	
	@Query("select u from Users u where u.prenom like %?1 and u.password > ?2")
	Users login(String prenom,String password);
	
	@Query("select u from Users u where u.prenom like %?1")
	Users findUsersByPrenom(String prenom);
	
	@Query("select u from Users u where u.email like %?1")
	Users findUsersByEmail(String email);
	
	
	
	List<Users>findUsersByNameContains(String na);

	@Query("select u from Users u where u.prenom like %?1")
	List<Users>findUserByPrenom(String prenom);
	

	@Query(" select r from Roles r")
	List<Roles> finUserByRoles(Roles role);
	
	@Query("select u from Users u order by u.name ASC")
	List<Users>findUsersByNamesAsc();
	
	@Query("select u from Users u order by u.name DESC")
	List<Users>findUsersByNamesDesc();
    
	@Query("select u from Users u ")
	List<Users> getAllUsers();

	@Query("select u from Users u where u.prenom like %?1")
	List<Users> findUserByPrenomContains(String pre);

	


	


}
