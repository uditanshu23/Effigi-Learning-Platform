package com.LearningPortal.spring.LearningPortal.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	User findById(long userId);
	
	List<User> findByUserRole(String role);
	
}
