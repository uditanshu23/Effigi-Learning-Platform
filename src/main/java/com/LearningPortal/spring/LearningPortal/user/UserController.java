package com.LearningPortal.spring.LearningPortal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/user")
	public String viewHomePage() {
		return "welcome";
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
//	@GetMapping("/user/{userId}")
//	public User getById(long userId) {
//		
//	}
}
