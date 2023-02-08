package com.LearningPortal.spring.LearningPortal.user;

import java.sql.Date;
//import java.util.List;

//import com.LearningPortal.spring.LearningPortal.course.Course;
//import com.LearningPortal.spring.LearningPortal.course.SubscribedCourse;
//import com.fasterxml.jackson.annotation.JsonProperty;

//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "UserId")
//	@JsonProperty("id")
	private long id;

	@Column(name = "UserName")
//	@JsonProperty("name")
	private String username;

	@Column(name = "UserEmail")
//	@JsonProperty("email")
	private String email;

	@Column(name = "CourseId")
//	@JsonProperty("courseId")
	private long courseId;

	@Column(name = "BirthDate")
//	@JsonProperty("birthDate")
	private Date birthDate;

	@Column(name = "PhoneNo")
//	@JsonProperty("phoneNumber")
	private long phoneNo;

	@Column(name = "UserRole")
//	@JsonProperty("role")
	private String userRole;

	@Column(name = "UserType")
//	@JsonProperty("type")
	private String userType;
	
//	@JsonProperty("favorites")
//	private List<Course> favoriteCourses;
//	
//	@JsonProperty("subscriptions")
//	private List<SubscribedCourse> subscribedCourses;

	public User() {}

	public User(long id, String username, String email, long courseId, Date birthDate, long phoneNo, String userRole,
			String userType) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.courseId = courseId;
		this.birthDate = birthDate;
		this.phoneNo = phoneNo;
		this.userRole = userRole;
		this.userType = userType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

//	public List<Course> getFavoriteCourses() {
//		return favoriteCourses;
//	}
//
//	public void setFavoriteCourses(List<Course> favoriteCourses) {
//		this.favoriteCourses = favoriteCourses;
//	}

//	public List<SubscribedCourse> getSubscribedCourses() {
//		return subscribedCourses;
//	}
//
//	public void setSubscribedCourses(List<SubscribedCourse> subscribedCourses) {
//		this.subscribedCourses = subscribedCourses;
//	}
}
