package com.springrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.entites.Courses;
import com.springrest.service.CourseServiceImpl;

@RestController
public class MyController {
	
	@Autowired
	private CourseServiceImpl courseService;
	
	// Get all the courses
	@GetMapping("/courses")
	public List<Courses> getCourses()
	{
		return courseService.getCourses();
	}
	
	// Get single course by id
	@GetMapping("/courses/{coursesId}")
	public Optional<Courses> getSingleCourse(@PathVariable Long coursesId)
	{
		return courseService.getSingleCourse(coursesId);
	}
	
	// Add course
	@PostMapping("/courses")
	public Courses addCourses(@RequestBody Courses courses)
	{
		return courseService.addCourse(courses);
	}
	
	// Update course
	@PutMapping("/courses")
	public Courses updateCourse(@RequestBody Courses courses)
	{
		return courseService.updateCourses(courses);
	}
	
	// Delete course
	@DeleteMapping("courses/{coursesId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long coursesId)
	{
		try {
			courseService.deleteCourse(coursesId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Delete All the courses
	@DeleteMapping("/courses")
	public String deleteAllCourses()
	{
		courseService.deleteAllCourses();
		return "All courses deleted";
	}
}
