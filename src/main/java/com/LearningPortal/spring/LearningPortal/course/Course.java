package com.LearningPortal.spring.LearningPortal.course;

import com.LearningPortal.spring.LearningPortal.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

	@Id
	@Column(name = "CourseId")
	private int courseId;

	@Column(name = "CourseName")
	private String courseName;

	@Column(name = "CourseDuration")
	private float courseDuration;

	@Column(name = "InstructorId")
	private int instructorId;

	private User instructor;

	public Course(int courseId, String courseName, float courseDuration, int instructorId) {
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
