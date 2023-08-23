package com.mapping.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapping.entites.Student;
import com.mapping.repo.StudentRepository;


@Service
public class StudentService {

	@Autowired
	private StudentRepository repo;
	
	public List<Student> getStudents()
	{
		return (List<Student>) repo.findAll();
	}
	
	public Student getSingleStudent(int id)
	{
		return repo.findById(id);
	}
	
	public Student addStudent(Student book)
	{
		return repo.save(book);
	}
	
	public Student updateStudent(Student student, int id)
	{
		student.setId(id);
		return repo.save(student);
	}
	
	public void deleteStudent(int id)
	{
		repo.deleteById(id);
	}
	
	public void deleteAllStudents()
	{
		repo.deleteAll();
	}
}
