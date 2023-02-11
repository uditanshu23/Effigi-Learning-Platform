package com.LearningPortal.spring.LearningPortal.user;

import java.util.List;
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

import com.LearningPortal.spring.LearningPortal.course.CourseRepository;
import com.LearningPortal.spring.LearningPortal.course.FavouriteCourse;
import com.LearningPortal.spring.LearningPortal.course.FavouriteCourseRepository;
import com.LearningPortal.spring.LearningPortal.course.SubscribedCourse;
import com.LearningPortal.spring.LearningPortal.course.SubscribedCourseRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private FavouriteCourseRepository favouriteCourseRepository;

	@Autowired
	private SubscribedCourseRepository subscribedCourseRepository;

	@GetMapping("/")
	public String viewHomePage() {
		return "welcome";
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getById(@PathVariable long userId) {
		Optional<User> user = userRepository.findById(userId);
		
		if (user.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(user.get(), HttpStatus.OK);
	}

	@PutMapping("/{userId}/favourite/{courseId}")
	public ResponseEntity<User> addFavourite(@PathVariable long userId, @PathVariable long courseId) {
		Optional<User> userResponse = userRepository.findById(userId);
		
		if (userResponse.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		User user = userResponse.get();
		
		List<FavouriteCourse> favourites = user.getFavoriteCourses();

		// Check if course already added
		boolean hasCourse = favourites.stream().anyMatch(course -> course.getCourse().getCourseId() == courseId);
		if (hasCourse)
			return new ResponseEntity<User>(user, HttpStatus.OK);

		// Check if course exists
		boolean courseExists = courseRepository.existsById(courseId);
		if (!courseExists)
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);

		// Add course to user favourites
		FavouriteCourse favouriteCourse = favouriteCourseRepository
				.save(new FavouriteCourse(favouriteCourseRepository.count() + 1, userId, courseId));
		favourites.add(favouriteCourse);
		user.setFavoriteCourses(favourites);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@DeleteMapping("/{userId}/favourite/{courseId}")
	public ResponseEntity<User> deleteFavourite(@PathVariable long userId, @PathVariable long courseId) {
		Optional<User> userResponse = userRepository.findById(userId);
		
		if (userResponse.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		User user = userResponse.get();
		
		List<FavouriteCourse> favourites = user.getFavoriteCourses();

		// Check if course added
		boolean hasCourse = favourites.stream().anyMatch(course -> course.getCourse().getCourseId() == courseId);
		if (!hasCourse)
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);

		// Remove course from user favourites
		Optional<FavouriteCourse> favouriteCourse = favourites.stream()
				.filter(course -> course.getCourse().getCourseId() == courseId).findFirst();
		favouriteCourseRepository.deleteById(favouriteCourse.get().getFavouriteId());
		favourites.removeIf(course -> course.getCourse().getCourseId() == courseId);
		user.setFavoriteCourses(favourites);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PutMapping("/{userId}/subscription/{courseId}")
	public ResponseEntity<User> addSubscription(@PathVariable long userId, @PathVariable long courseId) {
		Optional<User> userResponse = userRepository.findById(userId);
		
		if (userResponse.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		User user = userResponse.get();
		
		List<SubscribedCourse> subscriptions = user.getSubscribedCourses();

		// Check if course already added
		boolean hasCourse = subscriptions.stream().anyMatch(course -> course.getCourse().getCourseId() == courseId);
		if (hasCourse)
			return new ResponseEntity<User>(user, HttpStatus.OK);

		// Check if course exists
		boolean courseExists = courseRepository.existsById(courseId);
		if (!courseExists)
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);

		// Add course to user subscriptions
		SubscribedCourse subscribedCourse = subscribedCourseRepository
				.save(new SubscribedCourse(subscribedCourseRepository.count() + 1, userId, courseId, 0, 'P'));
		subscriptions.add(subscribedCourse);
		user.setSubscribedCourses(subscriptions);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@DeleteMapping("/{userId}/subscription/{courseId}")
	public ResponseEntity<User> deleteSubscription(@PathVariable long userId, @PathVariable long courseId) {
		Optional<User> userResponse = userRepository.findById(userId);
		
		if (userResponse.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		User user = userResponse.get();
		
		List<SubscribedCourse> subscriptions = user.getSubscribedCourses();

		// Check if course added
		boolean hasCourse = subscriptions.stream().anyMatch(course -> course.getCourse().getCourseId() == courseId);
		if (!hasCourse)
			return new ResponseEntity<User>(user, HttpStatus.BAD_REQUEST);

		// Remove course from user subscriptions
		Optional<SubscribedCourse> subscribedCourse = subscriptions.stream()
				.filter(course -> course.getCourse().getCourseId() == courseId).findFirst();
		subscribedCourseRepository.deleteById(subscribedCourse.get().getSubscriptionId());
		subscriptions.removeIf(course -> course.getCourse().getCourseId() == courseId);
		user.setSubscribedCourses(subscriptions);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
