package com.LearningPortal.spring.LearningPortal.course;

import com.LearningPortal.spring.LearningPortal.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

	@Id
	@Column(name = "CourseId")
	@JsonProperty("id")
	private long courseId;

	@Column(name = "CourseName")
	@JsonProperty("name")
	private String courseName;

	@Column(name = "CourseDuration")
	@JsonProperty("duration")
	private float courseDuration;

	@Column(name = "InstructorId", insertable = true, updatable = true)
	@JsonProperty("instructorId")
	private long instructorId;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="InstructorId", insertable = false, updatable = false)
	@JsonProperty("instructor")
	private User instructor;
	
	public Course() {}

	public Course(long courseId, String courseName, float courseDuration, User instructor) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.instructorId = instructor.getUserId();
		this.instructor = instructor;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public float getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(float courseDuration) {
		this.courseDuration = courseDuration;
	}

	public long getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	public User getInstructor() {
//		return instructor.getBasicUser();
		return instructor;
	}

	public void setInstructor(User instructor) {
//		this.instructor = instructor.getBasicUser();
		this.instructor = instructor;
	}

}
