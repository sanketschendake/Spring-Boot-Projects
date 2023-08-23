package com.mapping.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mapping.entites.Student;
import com.mapping.services.StudentService;



@Controller
//@RequestMapping("studentController")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping("/student")
	public ResponseEntity<List<Student>> getStudents()
	{
		List<Student> students = service.getStudents();
		if(students.size() <= 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(students);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getSinglStudent(@PathVariable Integer id)
	{
	 	Student student = service.getSingleStudent(id);
	 	if(student == null)
	 		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	 	return ResponseEntity.of(Optional.of(student));
	 	
	}
	
	@PostMapping("/student")
	public ResponseEntity<Student> addStudent(@RequestBody Student student)
	{
		try {
			service.addStudent(student);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Integer id)
	{
		try {
			service.updateStudent(student, id);
			return ResponseEntity.ok().body(student);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Integer id)
	{
		try {
			service.deleteStudent(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/student")
	public String deleteAllStudents()
	{
		service.deleteAllStudents();
		return "All books deleted";
	}
}
