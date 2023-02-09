package com.LearningPortal.spring.LearningPortal.course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

	Course findById(long courseId);
	
	List<Course> findByInstructorId(long instructorId);

}
