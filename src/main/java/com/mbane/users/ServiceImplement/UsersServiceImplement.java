package com.mbane.users.ServiceImplement;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbane.users.Entity.Roles;
import com.mbane.users.Entity.Users;
import com.mbane.users.Reposity.UsersReposity;
import com.mbane.users.ServiceInterface.UserServiceInterface;


@Service
public class UsersServiceImplement implements UserServiceInterface{

	@Autowired
	UsersReposity usersReposity;
	
	
	
	@Override
	public Users getUserbyId(Long id) {
		// TODO Auto-generated method stub
		return usersReposity.findById(id).get();
	}

	@Override
	public Users saveUsers(Users us) {
		// TODO Auto-generated method stub
		return usersReposity.save(us);
	}


	@Override
	public void deleteUsers(Users us) {
		usersReposity.deleteAll();
		
	}

	@Override
	public void delecUsersById(Long id) {
		usersReposity.deleteById(id);
		
	}

	@Override
	public List<Users> getAllUsers() {
		
		return usersReposity.findAll();
	}


	@Override
	public List<Users> findUsersByNameContains(String Na) {
		
		return usersReposity.findUsersByNameContains(Na);
	}

	@Override
	public List<Users> findUserByPrenomContains(String pre) {
		// TODO Auto-generated method stub
		return usersReposity.findUserByPrenomContains(pre);
	}


	@Override
	public List<Users> findUsersByNamesASC() {
		// TODO Auto-generated method stub
		return usersReposity.findUsersByNamesAsc();
	}

	@Override
	public List<Roles> finUserByRoles(Roles role) {
		// TODO Auto-generated method stub
		return usersReposity.finUserByRoles(role);
	}


	@Override
	public Users updatUsers(Users us) {
		// TODO Auto-generated method stub
		return usersReposity.save(us);
	}

	@Override
	public Users login(String prenom, String password) {
		Users us= usersReposity.login(prenom, password);
		return us;
	}

	@Override
	public Users findUsersByPrenom(String prenom) {
		// TODO Auto-generated method stub
		Users us=usersReposity.findUsersByPrenom(prenom);
		return us;
	}
	
	@Override
	public Users findUsersByPassword(String pass) {
		// TODO Auto-generated method stub		
		return usersReposity.findUsersByPassword(pass);
	}

	@Override
	public Users findUsersByEmail(String Email) {
		// TODO Auto-generated method stub
		return usersReposity.findUsersByEmail(Email);
	}


}
