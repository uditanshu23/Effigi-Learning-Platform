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

import com.LearningPortal.spring.LearningPortal.course.CourseRepository;
import com.LearningPortal.spring.LearningPortal.course.FavouriteCourse;
import com.LearningPortal.spring.LearningPortal.course.FavouriteCourseRepository;
import com.LearningPortal.spring.LearningPortal.course.SubscribedCourse;
import com.LearningPortal.spring.LearningPortal.course.SubscribedCourseRepository;
import com.LearningPortal.spring.LearningPortal.user.User;
import com.LearningPortal.spring.LearningPortal.user.UserController;
import com.LearningPortal.spring.LearningPortal.user.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserControllerUnitTest {

	@Mock
	private UserRepository userRepository;

	@Mock
	private CourseRepository courseRepository;

	@Mock
	private FavouriteCourseRepository favouriteCourseRepository;

	@Mock
	private SubscribedCourseRepository subscribedCourseRepository;

	@InjectMocks
	private UserController userController;

	@Test
	public void givenMockingIsDoneByMockito_whenGetUserIdIsCalled_shouldReturnMockedObject() throws ParseException {
		User user = MockedData.getStudent();

		Mockito.when(userRepository.findById(0)).thenReturn(Optional.empty());
		Mockito.when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));

		// If user does not exist
		Assertions.assertEquals(new ResponseEntity<User>(HttpStatus.NOT_FOUND), userController.getById(0));

		// If user exists
		Assertions.assertEquals(new ResponseEntity<User>(user, HttpStatus.OK),
				userController.getById(user.getUserId()));
	}

	@Test
	public void givenMockingIsDoneByMockito_whenAddFavoriteIsCalled_shouldReturnMockedObject() throws ParseException {
		User user = MockedData.getStudent();
		FavouriteCourse favouriteCourse = MockedData.getMockedFavourite(true);

		Mockito.when(userRepository.findById(0)).thenReturn(Optional.empty());
		Mockito.when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));

		Mockito.when(courseRepository.existsById(0L)).thenReturn(false);
		Mockito.when(courseRepository.existsById(favouriteCourse.getCourseId())).thenReturn(true);

		// If user does not exist
		Assertions.assertEquals(new ResponseEntity<>(HttpStatus.BAD_REQUEST), userController.addFavourite(0, 0));

		// If Favorite course already exists
		Assertions.assertEquals(new ResponseEntity<>(user, HttpStatus.OK),
				userController.addFavourite(user.getUserId(), 4));

		// If course doesn't exist
		Assertions.assertEquals(new ResponseEntity<>(user, HttpStatus.NOT_FOUND),
				userController.addFavourite(user.getUserId(), 0));

		// Add new Favorite course
		Assertions.assertEquals(new ResponseEntity<>(user, HttpStatus.OK),
				userController.addFavourite(user.getUserId(), favouriteCourse.getCourseId()));
	}

	@Test
	public void givenMockingIsDoneByMockito_whenDeleteFavoriteIsCalled_shouldReturnMockedObject() throws ParseException {
		User user = MockedData.getStudent();
		FavouriteCourse favouriteCourse = MockedData.getMockedFavourite(false);
		
		Mockito.when(userRepository.findById(0)).thenReturn(Optional.empty());
		Mockito.when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));
		
		// If user does not exist
		Assertions.assertEquals(new ResponseEntity<>(HttpStatus.BAD_REQUEST), userController.deleteFavourite(0, 0));
		
		// If course doesn't exist
		Assertions.assertEquals(new ResponseEntity<>(user, HttpStatus.NOT_FOUND),
				userController.deleteFavourite(user.getUserId(), 0));
		
		// Delete Favorite course
		Assertions.assertEquals(new ResponseEntity<>(user, HttpStatus.OK),
				userController.deleteFavourite(user.getUserId(), favouriteCourse.getCourseId()));
	}
	
	@Test
	public void givenMockingIsDoneByMockito_whenAddSubscriptionIsCalled_shouldReturnMockedObject()
			throws ParseException {
		User user = MockedData.getStudent();
		SubscribedCourse subscribedCourse = MockedData.getMockedSubscription(true);

		Mockito.when(userRepository.findById(0)).thenReturn(Optional.empty());
		Mockito.when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));

		Mockito.when(courseRepository.existsById(0L)).thenReturn(false);
		Mockito.when(courseRepository.existsById(subscribedCourse.getCourseId())).thenReturn(true);

		// If user doesn't exist
		Assertions.assertEquals(new ResponseEntity<>(HttpStatus.BAD_REQUEST), userController.addSubscription(0, 0));
		
		// If Subscribed course already exists
		Assertions.assertEquals(new ResponseEntity<>(user, HttpStatus.OK),
				userController.addSubscription(user.getUserId(), 4));
		
		// If course doesn't exist
		Assertions.assertEquals(new ResponseEntity<>(user, HttpStatus.NOT_FOUND),
				userController.addSubscription(user.getUserId(), 0));
		
		// Add new subscribed course
		Assertions.assertEquals(new ResponseEntity<>(user, HttpStatus.OK),
				userController.addSubscription(user.getUserId(), subscribedCourse.getCourseId()));
	}
	
	@Test
	public void givenMockingIsDoneByMockito_whenDeleteSubscriptionIsCalled_shouldReturnMockedObject() throws ParseException {
		User user = MockedData.getStudent();
		SubscribedCourse subscribedCourse = MockedData.getMockedSubscription(false);
		
		Mockito.when(userRepository.findById(0)).thenReturn(Optional.empty());
		Mockito.when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));
		
		// If user does not exist
		Assertions.assertEquals(new ResponseEntity<>(HttpStatus.BAD_REQUEST), userController.deleteFavourite(0, 0));
		
		// If course doesn't exist
		Assertions.assertEquals(new ResponseEntity<>(user, HttpStatus.NOT_FOUND),
				userController.deleteFavourite(user.getUserId(), 0));
		
		// Delete Subscribed course
		Assertions.assertEquals(new ResponseEntity<>(user, HttpStatus.OK),
				userController.deleteFavourite(user.getUserId(), subscribedCourse.getCourseId()));
	}

}
