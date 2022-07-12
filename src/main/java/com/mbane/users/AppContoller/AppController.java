package com.mbane.users.AppContoller;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	private String Homepage() 
	{
		return "menubare2";
	}
	
	@GetMapping("/home")
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
	public String loginprocess(Users user,ModelMap modelMap) 
	{
		
		Users outlog= userServiceInterface.findUsersByPrenom(user.getPrenom());
		
		if(user.getPassword().equals(outlog.getPassword())) 
		{
			modelMap.addAttribute("user",outlog);			
			return  "Userprofile"; 
			
		}else {
			return"Login1";
		}
					
		
	}
	
	@GetMapping("/Userprofile")
	public String userProfile(Users user,ModelMap model) 
	{	
		System.out.println("UserEdtit user.....: "+user);
		model.addAttribute("user",user);
		return "EditPtofile";
	} 
	
	
	  @GetMapping("/EditPtofile") 
	  public String userEditProfile(@RequestParam ("id") Long id, ModelMap model)
	  {
		
		  Users user=userServiceInterface.getUserbyId(id);
		  System.out.println("UserEdtit....: "+user);
		  model.addAttribute("user",user);
		
	  return "EditPtofile";
	  }
	 
	
	
	@GetMapping("/register")
	String ShowSignUpForm(Model model,@ModelAttribute("user") Users user) 
	{	

		model.addAttribute("user",user);
		return "Singup_form1";
	}
	
	@PostMapping("/process_register")
	public String processEnregistion(@ModelAttribute("user") Users user) 
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
	
	@PostMapping("/user_updated")
	public String usersUpdated(Users user) 
	{
		Users us =usersReposity.findUsersByEmail(user.getEmail());
		System.out.println("Before Rested......: "+us);
		us.setId_user(us.getId_user());
		us.setName(user.getName());
		us.setCompany(user.getCompany());
		us.setPhone(user.getPhone());
		us.setAddress(user.getAddress());
		userServiceInterface.updatUsers(us);
		System.out.println("After Rested....: "+us);
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
	
	public Users userProfiles(Users user) 
	{
		return user;
		
	}
	
	
	@RequestMapping("/AdminUserProfileList")
	public String AdminUserProfileList(ModelMap model) 
	{
		List<Users>us =userServiceInterface.getAllUsers();
		model.addAttribute("user",us);
		return"AdminUserProfileList";
	}
	
}
