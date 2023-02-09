package com.LearningPortal.spring.LearningPortal.course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
//	
//	Course findById(long courseId);

}
