package com.LearningPortal.spring.LearningPortal;

import java.text.ParseException;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.LearningPortal.spring.LearningPortal.course.Course;
import com.LearningPortal.spring.LearningPortal.course.CourseController;
import com.LearningPortal.spring.LearningPortal.course.CourseRepository;
import com.LearningPortal.spring.LearningPortal.course.FavouriteCourseRepository;
import com.LearningPortal.spring.LearningPortal.course.SubscribedCourseRepository;
import com.LearningPortal.spring.LearningPortal.user.User;
import com.LearningPortal.spring.LearningPortal.user.UserRepository;

@ExtendWith(MockitoExtension.class)
public class CourseControllerUnitTest {
	
	@Mock
	private UserRepository userRepository;

	@Mock
	private CourseRepository courseRepository;
	
	@Mock
	private FavouriteCourseRepository favouriteCourseRepository;
	
	@Mock
	private SubscribedCourseRepository subscribedCourseRepository;
	
	@InjectMocks
	private CourseController courseController;
	
	@Test
	public void givenMockingIsDoneByMockito_whenGetCourseByIdIsCalled_shouldReturnMockedObject () throws ParseException {
		Course course = MockedData.getMockedCourse(true);
		
		Mockito.when(courseRepository.findById(0)).thenReturn(Optional.empty());
		Mockito.when(courseRepository.findById(course.getCourseId())).thenReturn(Optional.of(course));
		
		// If course doesn't exist
		Assertions.assertEquals(new ResponseEntity<Course>(HttpStatus.NOT_FOUND), courseController.getCourseById(0));
		
		// If course exists
		Assertions.assertEquals(new ResponseEntity<Course>(course, HttpStatus.OK), courseController.getCourseById(course.getCourseId()));
	}
	
	@Test
	public void givenMockingIsDoneByMockito_whenAddCourseIsCalled_shouldReturnMockedObject() throws ParseException {
		User instructor = MockedData.getInstructor();
		Course course = MockedData.getMockedCourse(true);
		
		Mockito.when(userRepository.findById(0)).thenReturn(Optional.empty());
		Mockito.when(userRepository.findById(instructor.getUserId())).thenReturn(Optional.of(instructor));
		
		Mockito.when(courseRepository.count()).thenReturn(5L);
		
		// If user doesn't exist
		Assertions.assertEquals(new ResponseEntity<Course>(HttpStatus.BAD_REQUEST), courseController.addCourse("", 0, 0));
		
		// Add new course
		ResponseEntity<Course> response = courseController.addCourse(course.getCourseName(), course.getCourseDuration(), instructor.getUserId());
		Assertions.assertTrue(
				response.getBody().getCourseId() == course.getCourseId() &&
				response.getBody().getCourseName() == course.getCourseName() &&
				response.getBody().getCourseDuration() == course.getCourseDuration() &&
				response.getBody().getInstructorId() == course.getInstructorId()
				);
	}
	
	@Test
	public void givenMockingIsDoneByMockito_whenDeleteCourseIsCalled_shouldReturnMockedObject() throws ParseException {
		Course course = MockedData.getMockedCourse(false);

		Mockito.when(courseRepository.existsById(0L)).thenReturn(false);
		Mockito.when(courseRepository.existsById(course.getCourseId())).thenReturn(true);
		
		// If course exists
		Assertions.assertEquals(new ResponseEntity<>(HttpStatus.NOT_FOUND), courseController.deleteCourse(0));
		
		Assertions.assertEquals(new ResponseEntity<>(HttpStatus.OK), courseController.deleteCourse(course.getCourseId()));
	}

}











































