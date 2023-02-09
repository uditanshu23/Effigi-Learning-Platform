package com.LearningPortal.spring.LearningPortal.course;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user_favourites")
public class FavouriteCourse {
	
	@Id
	@Column(name="FavouriteId")
	@JsonProperty("id")
	private long favouriteId;
	
	@Column(name="UserId")
	private long userId;
	
	@Column(name="CourseId", insertable = true, updatable = true)
	private long courseId;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CourseId", insertable = false, updatable = false)
	@JsonProperty("course")
	private Course course;

	public FavouriteCourse() {
		// TODO Auto-generated constructor stub
	}

	public FavouriteCourse(long favouriteId) {
		super();
		this.favouriteId = favouriteId;
	}

	public FavouriteCourse(long favouriteId, long userId, long courseId) {
		super();
		this.favouriteId = favouriteId;
		this.userId = userId;
		this.courseId = courseId;
	}

	public long getFavouriteId() {
		return favouriteId;
	}

	public void setFavouriteId(long favouriteId) {
		this.favouriteId = favouriteId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
