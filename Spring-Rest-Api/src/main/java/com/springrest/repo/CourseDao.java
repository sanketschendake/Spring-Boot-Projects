package com.springrest.repo;

import org.springframework.data.repository.CrudRepository;

import com.springrest.entites.Courses;

public interface CourseDao extends CrudRepository<Courses, Long>{
	public Courses findById(Integer id);
}
