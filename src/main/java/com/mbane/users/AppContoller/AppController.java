package com.mbane.users.AppContoller;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.mbane.users.Entity.Roles;
import com.mbane.users.Entity.Users;
import com.mbane.users.Reposity.RolesReposity;
import com.mbane.users.Reposity.UsersReposity;
import com.mbane.users.ServiceInterface.UserServiceInterface;




@Controller
public class AppController {
	

	@Autowired 
	private RolesReposity rolesReposity;
	@Autowired
	private UsersReposity usersReposity;
	
	@Autowired
	private UserServiceInterface userServiceInterface;
	
	@GetMapping("")
	private String viewHomepage() 
	{
		return "index";
	}
	
	
	@GetMapping("/Login")
	private String Loginpage(Model model) 
	{
		Users us = new Users();
		model.addAttribute("user",us);
		return "Login1";
	}
	
	@PostMapping("/action_Login")
	public String loginprocess(Users user) 
	{
		
		System.out.println("Premon: "+user.getPrenom());
		System.out.println("Password: "+user.getPassword());
		
		Users outlog= userServiceInterface.findUsersByPrenom(user.getPrenom());
		System.out.println(outlog);
		
		if(user.getPassword().equals(outlog.getPassword())) 
		{
			
			return userProfile(outlog);
			
		}else {
			
			return"Login1";
		}
					
		
	}
	
	public String userProfile(Users user) 
	{
		
		return "Userprofile";
	} 
	
	
	@GetMapping("/register")
	String ShowSignUpForm(Model model) 
	{	
		Users customer= new Users();
		model.addAttribute("user",customer);
		return "Singup_form1";
	}
	
	@PostMapping("/process_register")
	public String processEnregistion(Users user) 
	{
		userServiceInterface.saveUsers(user);	
		return"success_register";
	}
		
	
	@GetMapping("/sign_in")
	String ShowSignIn(Model model) 
	{	
		return "Login1";
	}
	
	@GetMapping("/rest_Password")
	String restPassword(Model model) 
	{	
		Users customer= new Users();
		model.addAttribute("user",customer);
		return "restpassword";
	}
	
	@PostMapping("/rest_process")
	public String resteEnregistion(Users user) 
	{
		Users us =usersReposity.findUsersByEmail(user.getEmail());
		us.setId_user(us.getId_user());
		us.setPassword(user.getPassword());
		userServiceInterface.updatUsers(us);
		System.out.println("Password as been Rested: "+us);
		return"success_register";
	}
	
	
	
	
	
	
	@PostMapping("/SaveRoles")
	public ResponseEntity<String> saveRoles(@RequestBody List<Roles> roleData)
	{
		rolesReposity.saveAll(roleData);
		return ResponseEntity.ok("Data Save");
			
	}
	
	@RequestMapping(name = "/Update",method = RequestMethod.PUT)
	private Users usersupdate(@RequestBody Users users) 
	{
		
		return userServiceInterface.updatUsers(users);
	}
}
