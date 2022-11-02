package com.gl.employeeservice.service;

import java.util.List;

import com.gl.employeeservice.model.User;

public interface UserService {
	
	public User addUser(User urs);
	public User getUserById(long id);
	public List<User> getAllUsers();
	public User updateUser(User usr);
	public void deleteUser(long id);
	public User deactivateUser(long id);
	public User changeRole(Long id, String newRole);
	User addRoleToUser(Long id, String newRole);

}
