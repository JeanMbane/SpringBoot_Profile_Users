package com.mbane.users.AppContoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbane.users.Entity.Users;
import com.mbane.users.ServiceInterface.UserServiceInterface;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TestLogingRestControl {

	@Autowired
	UserServiceInterface userServiceInterface;
	
	@RequestMapping(method = RequestMethod.GET)
	List<Users> getAllUsers()
	{
				return userServiceInterface.getAllUsers();

	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Users createUsers(@RequestBody Users us ) 
	{
		return userServiceInterface.updatUsers(us);
	}
	
	@RequestMapping(method =RequestMethod.POST)
	public Users updatedUser(Users us ) 
	{
		return userServiceInterface.saveUsers(us);
		
	}
	
	@RequestMapping(value = "/login",method =RequestMethod.POST )
	public Users userlogin(Users us) 
	{
		Users u = userServiceInterface.login(us.getPrenom(), us.getPassword());
		return u;
		
	}
	
}
