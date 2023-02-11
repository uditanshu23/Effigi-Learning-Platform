package com.LearningPortal.spring.LearningPortal.course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscribedCourseRepository extends JpaRepository<SubscribedCourse, Long> {

	void deleteByCourseId(long courseId);
}
