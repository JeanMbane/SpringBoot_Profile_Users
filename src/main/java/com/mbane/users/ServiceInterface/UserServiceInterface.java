package com.mbane.users.ServiceInterface;

import java.util.List;

import com.mbane.users.Entity.Roles;
import com.mbane.users.Entity.Users;

public interface UserServiceInterface {
	
	 Users getUserbyId(Long id);
	 Users saveUsers(Users us);
	 Users updatUsers(Users us);
	 Users findUsersByPrenom(String prenom);
     Users login(String prenom, String password);
	 Users findUsersByPassword(String pass);
	 Users findUsersByEmail(String Email);
	 
	 void deleteUsers(Users us);
	 void delecUsersById(Long id);
	 
	 List<Users>getAllUsers();
	 List<Users>findUsersByNameContains(String Na);
	 List<Users>findUserByPrenomContains(String pre);
	 List<Users>findUsersByNamesASC();
	 List<Roles> finUserByRoles(Roles role);

	
	 

}
