package com.LearningPortal.spring.LearningPortal.course;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name="user_subscriptions")
public class SubscribedCourse {
	
	@Id
	@Column(name="SubscriptionId")
	@JsonProperty("id")
	private long subscriptionId;
	
	@Column(name="CompletionPercentage")
	@JsonProperty("completionPercentage")
	private int completionPercentage;
	
	@Column(name="CurrentGrade")
	@JsonProperty("currentGrade")
	private char currentGrade;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CourseId")
	@JsonProperty("course")
	private Course course;

	public SubscribedCourse() {}

	public SubscribedCourse(long subscriptionId, int completionPercentage,
			char currentGrade) {
		super();
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
