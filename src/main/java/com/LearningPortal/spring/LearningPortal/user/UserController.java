package com.LearningPortal.spring.LearningPortal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class UserController {

	private UserRepository userRepository;
	
	@GetMapping("/user")
	public String viewHomePage() {
		return "welcome";
	}
	
	@Autowired
	public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	
	
	

//	public UserRepository getUserRepository() {
//		return userRepository;
//	}

//	public void setUserRepository(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}
	
//	@GetMapping("/user/{userId}")
//	public User getById(long userId) {
//		
//	}
}
