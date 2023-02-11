package com.LearningPortal.spring.LearningPortal;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.LearningPortal.spring.LearningPortal.course.Course;
import com.LearningPortal.spring.LearningPortal.course.FavouriteCourse;
import com.LearningPortal.spring.LearningPortal.course.SubscribedCourse;
import com.LearningPortal.spring.LearningPortal.user.User;

public class MockedData {
	
	public static User getInstructor() throws ParseException {
		User user1 = new User(2L, "Arvind", "arvindk@mail.com", new Date(395778600000L), 2345633456L, "instructor");
		user1.setFavoriteCourses(new ArrayList<FavouriteCourse>());
		user1.setSubscribedCourses(new ArrayList<SubscribedCourse>());
		return user1;
	}
	
	public static Course getMockedCourse(boolean newCourse) throws ParseException {
		Course course1 = new Course(4L, "SpringBoot", (float) 17.5, getInstructor());
		
		Course course2 = new Course(6L, "Flask", (float) 18.4, getInstructor());
		
		if (!newCourse) {
			return course1;
		} else {
			return course2;
		}
	}
	
	public static FavouriteCourse getMockedFavourite(boolean newFavourite) throws ParseException {
		FavouriteCourse favouriteCourse1 = new FavouriteCourse(0, 3, 4);
		favouriteCourse1.setCourse(getMockedCourse(false));
		
		FavouriteCourse favouriteCourse2 = new FavouriteCourse(3, 3, 6);
		favouriteCourse2.setCourse(getMockedCourse(true));
		
		if (!newFavourite) {
			return favouriteCourse1;
		} else {
			return favouriteCourse2;
		}
	}
	
	public static SubscribedCourse getMockedSubscription(boolean newSubscription) throws ParseException {
		SubscribedCourse subscribedCourse1 = new SubscribedCourse(1, 3, 4, 19, 'C');
		subscribedCourse1.setCourse(getMockedCourse(false));
		
		SubscribedCourse subscribedCourse2 = new SubscribedCourse(5, 3, 6, 19, 'C');
		subscribedCourse2.setCourse(getMockedCourse(true));
		
		if (!newSubscription) {
			return subscribedCourse1;
		} else {
			return subscribedCourse2;
		}
	}
	
	public static User getStudent() throws ParseException {
		User user2 = new User(3L, "Pritish", "pritish34@mail.com", new Date(1016649000000L), 8876541239L, "student");
		
		List<FavouriteCourse> user2Favourites = new ArrayList<FavouriteCourse>();
		user2Favourites.add(getMockedFavourite(false));
		user2.setFavoriteCourses(user2Favourites);
		
		List<SubscribedCourse> user2Subscribed = new ArrayList<SubscribedCourse>();
		user2Subscribed.add(getMockedSubscription(false));
		user2.setSubscribedCourses(user2Subscribed);
		
		return user2;
	}
	
}
