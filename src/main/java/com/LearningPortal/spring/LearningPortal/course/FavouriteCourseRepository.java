package com.LearningPortal.spring.LearningPortal.course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FavouriteCourseRepository extends JpaRepository<FavouriteCourse, Long> {

	void deleteByCourseId(long courseId);
}
