package com.springrest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.entites.Courses;

public interface CourseDao extends JpaRepository<Courses, Long>{

}
