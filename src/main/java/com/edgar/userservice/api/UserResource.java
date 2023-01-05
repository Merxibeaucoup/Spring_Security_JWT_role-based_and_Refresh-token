package com.edgar.userservice.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edgar.userservice.model.AppUser;
import com.edgar.userservice.services.UserService;


@RestController
@RequestMapping("/api")
public class UserResource {
	
	
	@Autowired
	private UserService userS;
	
	
	
	@GetMapping("/users")
	public ResponseEntity<List<AppUser>> getUsers(){
		return ResponseEntity.ok().body(userS.getUsers());
	}

}
