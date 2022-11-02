package com.gl.employeeservice.util;

import java.util.Arrays;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gl.employeeservice.model.Employee;
import com.gl.employeeservice.model.Role;
import com.gl.employeeservice.model.User;
import com.gl.employeeservice.repository.EmployeeRepository;
import com.gl.employeeservice.repository.RoleRepository;
import com.gl.employeeservice.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BootStrapApplicationData {

	private final UserRepository userRepo;
	private final RoleRepository roleRepo;
	private final EmployeeRepository employeeRepo;

	@Bean
	public PasswordEncoder pswdEncoder() {
		return new BCryptPasswordEncoder();
	}

	@EventListener(ApplicationReadyEvent.class)
	public void insertEmployee(ApplicationReadyEvent event) {

		// employee
		Employee ram = new Employee();
		ram.setName("Ram");
		ram.setEmail("ram@sita.com");
		this.employeeRepo.save(ram);

		// user

		User lakshman = new User();
		lakshman.setActive(true);
		lakshman.setEmail("lakshman@ayodhya.com");
		lakshman.setName("Lakshman");
		lakshman.setPassword(this.pswdEncoder().encode("welcome"));

		User bharat = new User();
		bharat.setActive(true);
		bharat.setEmail("bharat@ayodhya.com");
		bharat.setName("Bharat");
		bharat.setPassword(this.pswdEncoder().encode("welcome"));

		// Role-Admin
		Role admin = new Role();
		admin.setActive(true);
		admin.setRoleName("Admin");

		// Role-User
		Role user = new Role();
		user.setActive(true);
		user.setRoleName("User");

		// set the role of the user

		//
//		  admin.addUser(lakshman); 
//		  user.addUser(bharat); 
//		  user.addUser(lakshman);

		// set the user to the role
		
		roleRepo.save(user);
		roleRepo.save(admin);
		
		lakshman.addRole(admin);
		lakshman.addRole(user); //
		bharat.addRole(user);
		 
		
		userRepo.save(lakshman);
		userRepo.save(bharat);
		
		
		

	}
}
