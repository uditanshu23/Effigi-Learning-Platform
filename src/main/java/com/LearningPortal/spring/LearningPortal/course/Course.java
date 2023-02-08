package com.LearningPortal.spring.LearningPortal.course;

import com.LearningPortal.spring.LearningPortal.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;

//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import javax.persistence.*;

@Entity
@Table(name="courses")
public class Course {
	
	@Id
	@Column(name="CourseId")
	@JsonProperty("id")
	private int courseId;
	
	@Column(name="CourseName")
	@JsonProperty("name")
	private String courseName;
	
	@Column(name="CourseDuration")
	@JsonProperty("duration")
	private float courseDuration;
	
	@Column(name="InstructorId")
	@JsonProperty("instructorId")
	private int instructorId;
	
	@JsonProperty("instructor")
	private User instructor;

	public Course(@NotBlank int courseId) {
		super();
		this.courseId = courseId;
	}

	public Course(@NotBlank int courseId, @NotBlank String courseName) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
	}

	public Course(@NotBlank int courseId, @NotBlank String courseName, @NotBlank float courseDuration) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
	}

	public Course(@NotBlank int courseId, @NotBlank String courseName, @NotBlank float courseDuration,
			@NotBlank int instructorId) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.instructorId = instructorId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
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

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	public User getInstructor() {
		return instructor;
	}

	public void setInstructor(User instructor) {
		this.instructor = instructor;
	}

}
