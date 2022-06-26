package com.mbane.users;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.mbane.users.Entity.Roles;
import com.mbane.users.Entity.Users;
import com.mbane.users.Reposity.RolesReposity;
import com.mbane.users.Reposity.UsersReposity;
import com.mbane.users.ServiceInterface.UserServiceInterface;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserResepotoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	UserServiceInterface userServiceInterface;
	
	@Autowired
	UsersReposity usersReposity;
	
	@Autowired
	RolesReposity rolesReposity;

	

	@Test
	public void  TestCreatnewuser() 
	{

	    Roles role = new Roles(); 
	    role.setId_roles(1L);

	  
	    System.out.println("Roles: "+role);
	    System.out.println("");

		Users user= new Users("Jean","Mbane","jro@gmail.com","MJA","1235",role);
		user.setId_user(1L);
		user.setEnabled(true);
		Users saved= usersReposity.save(user);		
	    Users existUser =entityManager.find(Users.class, saved.getId());
	    assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
	    
	   // role.setUsers((List<Users>) user);
	
	    
		
	}

	@Test
	public void CreatRole() 
	{
		
		Roles role= new Roles("GUEST");
		Roles savesRole= rolesReposity.save(role);
		
		Roles exitRole = entityManager.find(Roles.class, savesRole.getId_roles());
		assertThat(exitRole.getStatus()).isEqualTo(role.toString());
	}


	@Test
	public void UpdateRole() 
	{
		String em="eva@gmail.com";
			
	   // Roles role = new Roles(); 
	    //role.setId_roles(1L);

	  
	    //System.out.println("Roles: "+role);
	    //System.out.println("");

		Users user= usersReposity.findUsersByEmail(em);
		System.out.println("Info: "+user);
		System.out.println("");
		System.out.println("Id_User: "+user.getId_user());
		System.out.println("Email: "+ user.getEmail());
		user.getId_user();
		
		user.setId_user(user.getId_user());
		user.setPrenom("ri");
		user.setPassword("12");
		
		userServiceInterface.updatUsers(user);
		System.out.println("Done.....");
		System.out.println("");
		System.out.println("Info: "+user);
		
		//user.setRoles(role);
		//user.setEnabled(true);
		//userServiceInterface.updatUsers(user);		
	
	}
	
	@Test
	void TestLogindroles() {
		Users use= new Users();
		use.setName("Lala");
		use.setPassword("15");
		
	Users l=userServiceInterface.login(use.getName(),use.getPassword());
		
	  if(Objects.nonNull(l)) 
			
		{	
			System.out.println("Log");
			System.out.println("");
		}
	 
	  
		    
		
	    
			//Users l= userServiceInterface.login("Mbane","789");
		//System.out.println("User_Login: "+userServiceInterface.login(use.getName(),use.getPassword()));
		
	
		
	}
	

	@Test
	public void TestPrenom() 
	{
		String pren="Rivi";
		String p="15";
		String pass;
		String pr;
		
		Users u= new Users();
		u.setPassword(p);
		u.setPrenom(pren);
		
	    Users us = userServiceInterface.findUsersByPrenom("Rivi");
	    System.out.println(us);
	    System.out.println("");
	    
	    pr= us.getPrenom();
	    pass=us.getPassword();
	    
	    System.out.println("Prenom: "+ pr);
	    System.out.println("Pass: "+pass);
	    System.out.println("PassNew: "+u.getPassword());
	    System.out.println("");
	    
	    if(u.getPassword().equals(us.getPassword())) 
	    {
	    System.out.println("Welcome.......");
	    System.out.println("");
	    	
	    }else 
	    {
	    	System.out.println("Try again ....................");
	    	System.out.println("");
	    }
	    
	    
	}
	
	@Test
	public void TestPrenomAndPass() 
	{
		String pren="Rivi";
		String p="15";
		
	    Users us = usersReposity.login("Rivi","15");
	    System.out.println("Users: "+us);
	    
	
	}
	
		/*
		List<Roles> r = rolesReposity.findRolesByStatusContains("A");
		for(Roles ro:r) 
		{
			System.out.println("Name: "+ro);
			
		}
		
	}
	/*
	@Test
	void findroles() {
		
    String Name="ADMIN";
    
	rolesReposity.findRolesByStatus(Name);
		
	}
	
	@Test
	
	void updateUserRole() 
	{
		Users us = usersReposity.findById(1L).get();
		List<Roles> ro = rolesReposity.findAll();
		for(Roles r:ro) 
		{
			System.out.println("Les ID ROles: "+r);
		//us.setRoles(ro);		
		}
		
	
		
	}
	
		*/

}
