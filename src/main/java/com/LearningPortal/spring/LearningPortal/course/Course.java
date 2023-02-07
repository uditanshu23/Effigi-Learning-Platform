package com.LearningPortal.spring.LearningPortal.course;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public class Course {
	
	@NotBlank
	@JsonProperty("courseId")
	private int courseId;
	
	@NotBlank
	@JsonProperty("courseName")
	private String courseName;
	
	@NotBlank
	@JsonProperty("courseDuration")
	private float courseDuration;
	
	@NotBlank
	@JsonProperty("instructorId")
	private int instructorId;

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

}
