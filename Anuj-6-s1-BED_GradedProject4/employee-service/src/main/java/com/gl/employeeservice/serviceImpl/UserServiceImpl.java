package com.gl.employeeservice.serviceImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.employeeservice.model.Role;
import com.gl.employeeservice.model.User;
import com.gl.employeeservice.repository.UserRepository;
import com.gl.employeeservice.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public User addUser(User urs) {
		// TODO Auto-generated method stub
		return userRepo.save(urs);
	}

	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id).get();
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User updateUser(User usr) {
		// TODO Auto-generated method stub
		User newUser = new User();
		newUser.setName(usr.getName());
		newUser.setEmail(usr.getEmail());
		newUser.setPassword(usr.getPassword());
		newUser.setMyRole(usr.getMyRole());
		newUser.setActive(usr.isActive());
		return userRepo.save(newUser);
	}

	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User deactivateUser(long id) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(id).get();
		user.setActive(false);
		return userRepo.save(user);
	}

	@Override
	public User addRoleToUser(Long id, String newRole) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(id).get();
		List<Role> roles = user.getMyRole();
//		Set<User> users = roles.
		
//		Role nr = new Role();
//		nr.setRoleName(newRole);
//		nr.setActive(true);
//		nr.setMyUser(user);
//		role.add(new Role());
		return null;
	}

	@Override
	public User changeRole(Long id, String newRole) {
		// TODO Auto-generated method stub
		return null;
	}

}
