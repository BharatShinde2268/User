package com.main.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.models.User;
import com.main.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		// generat unique id 
		String randomeUserId = UUID.randomUUID().toString();
		user.setUserId(randomeUserId);
		
		User createUser = userService.createUser(user);
		return new ResponseEntity<User>(createUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId)
	{
		User singleUser = userService.getSingleUser(userId);
		return new ResponseEntity<User>(singleUser,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<User> getAllUser()
	{
		List<User> allUser = userService.getAllUser();
		
		return new ResponseEntity<User>((com.main.models.User) allUser,HttpStatus.OK);
		
	}
	
}
