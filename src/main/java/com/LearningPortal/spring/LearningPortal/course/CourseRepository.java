package com.LearningPortal.spring.LearningPortal.course;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

	Optional<Course> findById(long courseId);
	
	List<Course> findByInstructorId(long instructorId);

}
