//package com.mbane.users.securityConf;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.mbane.users.Entity.Users;
//import com.mbane.users.Reposity.UsersReposity;
//
//public class CustomerTestLoginDetailsService implements UserDetailsService {
//
//	@Autowired
//	private UsersReposity  usRepo;
//	
//	@Override
//	public UserDetails loadUserByUsername(String prenom) throws UsernameNotFoundException {
//		 
//		Users user = usRepo.findUsersByPrenom(prenom);
//		 
//		 if(user==null) 
//		 {
//			 throw new UsernameNotFoundException(prenom+"Not found");
//			 
//		 }
//		 
//		return new CustomerTestLoginDetails(user);
//	}
//
//}
