package com.webosmotic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webosmotic.dao.UserRepository;
import com.webosmotic.entity.User;
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUser(){
		List<User> list = userRepository.findAll();
		return list;
	}
	
	public User getById(int id) {
		return userRepository.findById(id).get();
	}
	
	public void deleteById(int id) {
		userRepository.deleteById(id);
	}
	
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	public void createUser(User user) {
		userRepository.save(user);
	}

	
}
