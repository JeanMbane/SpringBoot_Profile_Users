package com.mbane.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.mbane.users.AppContoller","com.mbane.users.Entity","com.mbane.users.Reposity","com.mbane.users.securityConf","com.mbane.users.ServiceImplement","com.mbane.users.ServiceInterface"})
public class TestLogingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestLogingApplication.class, args);
		System.out.println("start Apps");
	}

}
