package com.springrest.service;

import java.util.List;
import java.util.Optional;

import com.springrest.entites.Courses;

public interface CourseService {

	public List<Courses> getCourses();
	
	public Optional<Courses> getSingleCourse(Long coursesId);
	
	public Courses addCourse(Courses courses);
	
	public Courses updateCourses(Courses courses);
	
	public void deleteCourse(Long courseId);
	
//	public boolean checkUserExist(Integer id);
}
