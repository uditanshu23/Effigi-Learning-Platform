package com.LearningPortal.spring.LearningPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.LearningPortal.spring")
public class LearningPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningPortalApplication.class, args);
	}

}
