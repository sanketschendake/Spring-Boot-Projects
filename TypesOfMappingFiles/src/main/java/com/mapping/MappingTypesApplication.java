package com.mapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mapping.entites.Department;
import com.mapping.entites.Student;
import com.mapping.entites.AmazonAccount;
import com.mapping.entites.Items;
import com.mapping.repo.AmazonRepository;
import com.mapping.repo.StudentRepository;

@SpringBootApplication
public class MappingTypesApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MappingTypesApplication.class, args);

		// One to many
//		AmazonRepository amazonRepository = context.getBean(AmazonRepository.class);
//		
//		AmazonAccount account = new AmazonAccount();
//		account.setId(1);
//		account.setName("Sanket");
//		
//		Items items = new Items();
//		items.setItemId(100);
//		items.setQuantity(2);
//		items.setName("laptop");
//		items.setAmazonAccount(account);
//		
//		Items items2 = new Items();
//		items2.setItemId(200);
//		items2.setQuantity(4);
//		items2.setName("mobile");
//		items2.setAmazonAccount(account);
//		
//		List<Items> allItems = new ArrayList<>();
//		allItems.add(items);
//		allItems.add(items2);
//		
//		account.setItems(allItems);
//		
//		amazonRepository.save(account);
		
		
		//many to many
//		StudentRepository studentRepository = context.getBean(StudentRepository.class);
//
//		Student student = new Student();
//		student.setStudentId(1);
//		student.setStudentName("Sanket");
//		student.setAbout("he is good");
//		
//		Student student2 = new Student();
//		student2.setStudentId(2);
//		student2.setStudentName("Rohan");
//		student2.setAbout("he is ok");
//		
//		Student student3 = new Student();
//		student3.setStudentId(3);
//		student3.setStudentName("Dev");
//		student3.setAbout("he is bad");
//		
//		
//		Department department = new Department();
//		department.setDeptId(100);
//		department.setDeptName("Science");
//
//		Department department2 = new Department();
//		department2.setDeptId(200);
//		department2.setDeptName("Computer");
//		
//		
//		// create list
//		List<Student> addStudents1 = new ArrayList<>();
//		addStudents1.add(student);
//		addStudents1.add(student2);
//		addStudents1.add(student3);
//		
//		department.setStudents(addStudents1);
//		
//		List<Student> addStudents2 = new ArrayList<>();
//		addStudents2.add(student);
//		addStudents2.add(student2);
//		addStudents2.add(student3);
//		
//		department2.setStudents(addStudents2);
//
//		// save 
//		studentRepository.save(student);
//		studentRepository.save(student2);
//		studentRepository.save(student3);
		
	}

}
