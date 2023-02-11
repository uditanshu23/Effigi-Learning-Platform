package com.LearningPortal.spring.LearningPortal.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findById(long userId);
	
	List<User> findByUserRole(String role);
	
}
