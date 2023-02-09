package com.LearningPortal.spring.LearningPortal.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseRepository courseRepository;

	@GetMapping("/")
	public String viewCourseHomePage() {
		return "welcome";
	}

	@GetMapping("/{courseId}")
	public ResponseEntity<Course> getCourseById(@PathVariable int courseId) {
		Course course = courseRepository.findById(courseId);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
}
