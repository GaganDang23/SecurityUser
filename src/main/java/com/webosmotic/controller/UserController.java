package com.webosmotic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webosmotic.entity.User;
import com.webosmotic.service.UserService;

@RestController
@RequestMapping("/home")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PreAuthorize("hasRole('GETALL')")
	@GetMapping("/user")
	private List<User> getAllUser(){
		return userService.getAllUser();	
	}
	
	@PreAuthorize("hasRole('GETUSERBYID')")
	@GetMapping("/user/{userId}")
	private User getUserById(@PathVariable("userId") int userId) {
		return userService.getById(userId);
		
	}
	
	@PreAuthorize("hasRole('DELETEUSER')")
	@DeleteMapping("/user/{userId}")
	private void deleteUserById(@PathVariable("userId") int userId) {
		userService.deleteById(userId);
	}
	
	
	@PreAuthorize("hasRole('UPDATEUSER')")
	@PutMapping("/user")
	private void updateUser(@RequestBody User user) {
		 userService.updateUser(user);
	}
	
	@PreAuthorize("hasRole('CREATEUSER')")
	@PostMapping("/user")
	private void createUser(@RequestBody User user) {
		userService.createUser(user);
	}
	
	

	
	
}
