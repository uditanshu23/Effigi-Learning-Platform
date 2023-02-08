package com.LearningPortal.spring.LearningPortal.course;

//import com.fasterxml.jackson.annotation.JsonProperty;

//import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

//@Entity
//@Table(name="user_subscriptions")
public class SubscribedCourse extends Course {
	
//	@Id
//	@Column(name="SubscriptionId")
//	@JsonProperty("id")
	private long subscriptionId;
//	
//	@Column(name="CompletionPercentage")
//	@JsonProperty("completionPercentage")
	private int completionPercentage;
//	
//	@Column(name="CurrentGrade")
//	@JsonProperty("currentGrade")
	private char currentGrade;

	public SubscribedCourse(@NotBlank int courseId) {
		super(courseId);
		// TODO Auto-generated constructor stub
	}

	public SubscribedCourse(@NotBlank int courseId, @NotBlank String courseName) {
		super(courseId, courseName);
		// TODO Auto-generated constructor stub
	}

	public SubscribedCourse(@NotBlank int courseId, @NotBlank String courseName, @NotBlank float courseDuration) {
		super(courseId, courseName, courseDuration);
		// TODO Auto-generated constructor stub
	}

	public SubscribedCourse(@NotBlank int courseId, @NotBlank String courseName, @NotBlank float courseDuration,
			@NotBlank int instructorId) {
		super(courseId, courseName, courseDuration, instructorId);
		// TODO Auto-generated constructor stub
	}

	public SubscribedCourse(@NotBlank int courseId, @NotBlank String courseName, @NotBlank float courseDuration,
			@NotBlank int instructorId, long subscriptionId, int completionPercentage, char currentGrade) {
		super(courseId, courseName, courseDuration, instructorId);
		this.subscriptionId = subscriptionId;
		this.completionPercentage = completionPercentage;
		this.currentGrade = currentGrade;
	}

	public long getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public int getCompletionPercentage() {
		return completionPercentage;
	}

	public void setCompletionPercentage(int completionPercentage) {
		this.completionPercentage = completionPercentage;
	}

	public char getCurrentGrade() {
		return currentGrade;
	}

	public void setCurrentGrade(char currentGrade) {
		this.currentGrade = currentGrade;
	}

}
