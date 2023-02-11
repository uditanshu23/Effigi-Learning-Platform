package com.LearningPortal.spring.LearningPortal.course;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LearningPortal.spring.LearningPortal.user.User;
import com.LearningPortal.spring.LearningPortal.user.UserRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FavouriteCourseRepository favouriteCourseRepository;

	@Autowired
	private SubscribedCourseRepository subscribedCourseRepository;

	@GetMapping("/")
	public String viewCourseHomePage() {
		return "welcome";
	}

	@GetMapping("/{courseId}")
	public ResponseEntity<Course> getCourseById(@PathVariable long l) {
		Optional<Course> course = courseRepository.findById(l);
		if (course.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(course.get(), HttpStatus.OK);
	}

	@PutMapping("/addCourse/{courseName}/{courseDuration}/{userId}")
	public ResponseEntity<Course> addCourse(@PathVariable String courseName, @PathVariable float courseDuration,
			@PathVariable long userId) {

		Optional<User> userResponse = userRepository.findById(userId);
		
		if (userResponse.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		User instructor = userResponse.get();
		
		Course course = new Course(courseRepository.count() + 1, courseName, courseDuration, instructor);
		courseRepository.save(course);

		return new ResponseEntity<>(course, HttpStatus.OK);
	}

	@DeleteMapping("/deleteCourse/{courseId}")
	@Transactional
	public ResponseEntity<Course> deleteCourse(@PathVariable long courseId) {
		boolean courseExists = courseRepository.existsById(courseId);
		if (!courseExists)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		favouriteCourseRepository.deleteByCourseId(courseId);
		subscribedCourseRepository.deleteByCourseId(courseId);
		courseRepository.deleteById(courseId);

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
