package com.main.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.main.exceptions.ResourceNotFoundExceptions;
import com.main.models.Rating;
import com.main.models.User;
import com.main.repository.UserRepository;
import com.main.service.UserService;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger=org.slf4j.LoggerFactory.getLogger(UserServiceImple.class);
	
	
	@Override
	public User createUser(User user) {
		User save = userRepository.save(user);
		
		return save;
	}

	@Override
	public User getSingleUser(String userId) {
		User user = userRepository.findById(userId).orElseThrow( () -> new ResourceNotFoundExceptions("User Not Found"));
		// fetch rating of the above user from rating service
		// 
		ArrayList<Rating> forObject = restTemplate.getForObject("http://localhost:8185/ratings/users/43a2d7cf-7dfc-40b4-b524-b1020b4f41f5",ArrayList.class);
		logger.info("{} ",forObject);
		
		return user;
	}

	@Override
	public List<User> getAllUser() {
		List<User> findAll = userRepository.findAll();
		return findAll;
	}

}
