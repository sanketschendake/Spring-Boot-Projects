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
	public ResponseEntity<List<Courses>> getCourses() {
		List<Courses> courses = courseService.getCourses();
		if (courses.size() <= 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(courses);
	}

	// Get single course by id
	@GetMapping("/courses/{coursesId}")
	public ResponseEntity<Courses> getSingleCourse(@PathVariable Integer coursesId) {
		Courses courses = courseService.getSingleCourse(coursesId);
		if (courses==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.of(Optional.of(courses));
	}

	// Add course
	@PostMapping("/courses")
	public ResponseEntity<Courses> addCourses(@RequestBody Courses courses) {
		try {
			courseService.addCourse(courses);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// Update course
	@PutMapping("/courses/{id}")
	public ResponseEntity<Courses> updateCourse(@RequestBody Courses courses, @PathVariable Integer id) {
		try {
			courseService.updateCourses(courses, id);
			return ResponseEntity.ok().body(courses);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// Delete course
	@DeleteMapping("courses/{coursesId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long coursesId) {
		try {
			courseService.deleteCourse(coursesId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Delete All the courses
	@DeleteMapping("/courses")
	public String deleteAllCourses() {
		courseService.deleteAllCourses();
		return "All courses deleted";
	}
}

/*
@RestController
public class MyController {

	@Autowired
	private CourseServiceImpl courseService;

	// Get all the courses
	@GetMapping("/courses")
	public List<Courses> getCourses() {
		return courseService.getCourses();
	}

	// Get single course by id
	@GetMapping("/courses/{coursesId}")
	public Optional<Courses> getSingleCourse(@PathVariable Long coursesId) {
		return courseService.getSingleCourse(coursesId);
	}

	// Add course
	@PostMapping("/courses")
	public Courses addCourses(@RequestBody Courses courses) {
		return courseService.addCourse(courses);
	}

	// Update course
	@PutMapping("/courses")
	public Courses updateCourse(@RequestBody Courses courses) {
		return courseService.updateCourses(courses);
	}

	// Delete course
	@DeleteMapping("courses/{coursesId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long coursesId) {
		try {
			courseService.deleteCourse(coursesId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Delete All the courses
	@DeleteMapping("/courses")
	public String deleteAllCourses() {
		courseService.deleteAllCourses();
		return "All courses deleted";
	}
}
*/