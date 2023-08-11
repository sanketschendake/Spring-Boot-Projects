package com.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.entites.Courses;
import com.springrest.repo.CourseDao;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao repo;

	public CourseServiceImpl() {
	}

	@Override
	public List<Courses> getCourses() {
		return (List<Courses>) repo.findAll();
	}

	@Override
	public Courses getSingleCourse(Integer coursesId) {
		return repo.findById(coursesId);
	}

	@Override
	public Courses addCourse(Courses courses) {
		repo.save(courses);	
		return courses;
	}

	@Override
	public Courses updateCourses(Courses courses, Integer id) {
		courses.setId(id);
		repo.save(courses);
		return courses;
	}

	@Override
	public void deleteCourse(Long courseId) {
		repo.deleteById(courseId);
//		list.stream().filter(e -> e.getId()!=courseId).collect(Collectors.toList());
	}

	@Override
	public void deleteAllCourses() {
		repo.deleteAll();
		
	}
}

/*
@Service
public class CourseServiceImpl implements CourseService {

	List<Courses> list;

	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Courses(1, "Java", "Java is programming language"));
		list.add(new Courses(2, "Python", "Python is programming language"));
	}

	@Override
	public List<Courses> getCourses() {
		return list;
	}

	@Override
	public Courses getSingleCourse(Integer coursesId) {
		Courses c = null;
		for (Courses courses : list) {
			if (courses.getId() == coursesId) {
				c = courses;
				break;
			}
		}

		return c;
	}

	@Override
	public Courses addCourse(Courses courses) {
		list.add(courses);
		return courses;
	}

	@Override
	public Courses updateCourses(Courses courses) {
		list.forEach(e -> {
			if (e.getId() == courses.getId()) {
				e.setTitle(courses.getTitle());
				e.setDescription(courses.getDescription());
			}
		});
		return courses;
	}

	@Override
	public void deleteCourse(Integer courseId) {
		list = list.stream().filter(e -> e.getId() != courseId).collect(Collectors.toList());
	}

//	@Override
//	public boolean checkUserExist(Integer id) {
//		boolean value = false;
//		for (Courses courses : list) {
//			if (courses.getId() == id) {
//				value = true;
//				break;
//			}
//		}
//		return value;
//	}

}
*/
