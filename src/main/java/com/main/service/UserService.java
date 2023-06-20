package com.main.service;

import java.util.List;

import com.main.models.User;

public interface UserService {
	
	public User createUser(User user);
	
	public User getSingleUser(String userId);
	
	public List<User> getAllUser();

}
