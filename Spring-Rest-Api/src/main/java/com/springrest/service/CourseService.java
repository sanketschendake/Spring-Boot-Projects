package com.springrest.service;

import java.util.List;

import com.springrest.entites.Courses;

public interface CourseService {

	public List<Courses> getCourses();
	
	public Courses getSingleCourse(Integer coursesId);
	
	public Courses addCourse(Courses courses);
	
	public Courses updateCourses(Courses courses, Integer id);
	
	public void deleteCourse(Long courseId);
	
	public void deleteAllCourses();
}
