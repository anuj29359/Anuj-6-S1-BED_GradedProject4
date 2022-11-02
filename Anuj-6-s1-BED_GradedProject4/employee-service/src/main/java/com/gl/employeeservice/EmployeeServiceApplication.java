package com.gl.employeeservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Component;

@EnableWebSecurity
@SpringBootApplication
public class EmployeeServiceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
		System.out.println("starting spring app");
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
