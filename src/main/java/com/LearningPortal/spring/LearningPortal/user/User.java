package com.LearningPortal.spring.LearningPortal.user;

import java.sql.Date;
import java.util.List;

import com.LearningPortal.spring.LearningPortal.course.FavouriteCourse;
import com.LearningPortal.spring.LearningPortal.course.SubscribedCourse;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "UserId")
	@JsonProperty("id")
	private long userId;

	@Column(name = "UserName")
	@JsonProperty("name")
	private String userName;

	@Column(name = "UserEmail")
	@JsonProperty("email")
	private String email;

	@Column(name = "BirthDate")
	@JsonProperty("birthDate")
	private Date birthDate;

	@Column(name = "PhoneNo")
	@JsonProperty("phoneNumber")
	private long phoneNo;

	@Column(name = "UserRole")
	@JsonProperty("role")
	private String userRole;

	@Column(name = "UserType")
	@JsonProperty("type")
	private String userType;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="UserId")
	@JsonProperty("favorites")
	private List<FavouriteCourse> favoriteCourses;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="UserId")
	@JsonProperty("subscriptions")
	private List<SubscribedCourse> subscribedCourses;

	public User() {}

	public User(long userId, String userName, String email, Date birthDate, long phoneNo, String userRole,
			String userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.birthDate = birthDate;
		this.phoneNo = phoneNo;
		this.userRole = userRole;
		this.userType = userType;
	}

	public long getUserId() {
		return userId;
	}

	public void setId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<FavouriteCourse> getFavoriteCourses() {
		return favoriteCourses;
	}

	public void setFavoriteCourses(List<FavouriteCourse> favoriteCourses) {
		this.favoriteCourses = favoriteCourses;
	}

	public List<SubscribedCourse> getSubscribedCourses() {
		return subscribedCourses;
	}

	public void setSubscribedCourses(List<SubscribedCourse> subscribedCourses) {
		this.subscribedCourses = subscribedCourses;
	}
	
//	public User getBasicUser() {
//		User tempUser = new User(userId, userName, email, birthDate, phoneNo, userRole,
//			userType);
//		tempUser.setFavoriteCourses(null);
//		tempUser.setSubscribedCourses(null);
//		return tempUser;
//	}
}
