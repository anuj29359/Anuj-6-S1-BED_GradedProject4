package com.gl.employeeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.employeeservice.model.User;
import com.gl.employeeservice.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@GetMapping
	public List<User> getAllUsers(){
		return userServiceImpl.getAllUsers();
	}

	@PostMapping
	public User addUser(@RequestBody User usr) {
		System.out.println("Adding new user :" + usr);
		System.out.println(usr);
		return userServiceImpl.addUser(usr);
	}
	
}
