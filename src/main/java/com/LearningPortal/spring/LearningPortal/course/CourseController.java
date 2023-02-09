package com.LearningPortal.spring.LearningPortal.course;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/c1")
public class CourseController {

	private CourseRepository courseRepository;

	@GetMapping("/course")
	public String viewCourseHomePage() {
		return "welcome";
	}

	public CourseController(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}

//	@GetMapping("/{id}")
//	public ResponseEntity<Course> getCourseById(@PathVariable("id") int id) {
//		Course course = courseRepository.findById(id);
//		System.out.print(course);
//		return new ResponseEntity<>(course, HttpStatus.OK);
//	}
}
