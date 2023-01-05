package com.edgar.userservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edgar.userservice.model.AppUser;
import com.edgar.userservice.model.Role;
import com.edgar.userservice.repository.RoleRepository;
import com.edgar.userservice.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	 private UserRepository userRepo;

	@Autowired
	 private RoleRepository roleRepo;
	
	

	public AppUser saveUser(AppUser user) {
		return userRepo.save(user);
	}

	public Role saveRole(Role role) {
		return roleRepo.save(role);
	}

	public void addRoleToUser(String username, String roleName) {
		
		AppUser user = userRepo.findByUsername(username);
		Role role = roleRepo.findByName(roleName);
		
		user.getRoles().add(role);
		
		
	}

	public AppUser getUser(String userName) {
		return userRepo.findByUsername(userName);
	}

	public List<AppUser> getUsers(){
		return userRepo.findAll();
	}

}
