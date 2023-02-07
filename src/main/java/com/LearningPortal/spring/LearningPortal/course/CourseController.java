package com.LearningPortal.spring.LearningPortal.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	CourseRepository courseRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable("id") int id) {
		Course course = courseRepository.findById(id);
		System.out.print(course);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
}
