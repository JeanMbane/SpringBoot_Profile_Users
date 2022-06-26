package com.mbane.users;



import java.util.List;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mbane.users.Entity.Users;
import com.mbane.users.Reposity.RolesReposity;
import com.mbane.users.Reposity.UsersReposity;
import com.mbane.users.ServiceInterface.RoleServiceInterface;

@SpringBootTest
class TestLogingApplicationTests {

	@Autowired
	RolesReposity rolesReposity;
	
	@Autowired
	UsersReposity usersReposity;
	
	@Autowired
	RoleServiceInterface roleServiceInterface;
	
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void findByPrenom() 
	{
		
	
		
        List<Users> us=rolesReposity.findRolesByUsers();
        for(Users u : us) {
	
		System.out.println("\nUsers_Select: "+u);
		System.out.println("");
		
        }
		
	}

}
