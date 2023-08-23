package com.mapping.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.mapping.entites.Student;


public interface StudentRepository extends JpaRepository<Student, Integer>{

	public Student findById(int id);
}
