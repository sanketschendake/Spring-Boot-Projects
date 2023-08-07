package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.UserRepository;
import com.example.demo.entites.User;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);

		User user1 = new User();
		user1.setName("Sanket");
		user1.setCity("Pune");

		User user2 = new User();
		user2.setName("Abhi");
		user2.setCity("Baramti");
		
		User user3 = new User("Sayali", "Kolhapur");

		// Save single user
//		User user1Save = userRepository.save(user1);
//		System.out.println(user1Save);

		// Save multiple objects
		// use of method after java 9, for java 8 use list
//		List<User> saveAllUsers = List.of(user1, user2, user3);
//		Iterable<User> result = userRepository.saveAll(saveAllUsers);
//
//		// show the data
//		result.forEach(user -> 
//			System.out.println(user)
//		);

		
		// Update the user
//		Optional<User> optional = userRepository.findById(152);
//		User findUser = optional.get();
//		findUser.setName("Sanket Chendake");
//
//		User resultUser = userRepository.save(findUser);
//
//		System.out.println(resultUser);

		// Get single record
		// get by id
//		Optional<User> optional = userRepository.findById(152);
//		User user = optional.get();
//		System.out.println(user);

		// get all the data
//		Iterable<User> findAllData = userRepository.findAll();
//		findAllData.forEach(user -> System.out.println(user));
		
		
		// Delete
		// Id
//		userRepository.deleteById(154);
//		Iterable<User> allUsers = userRepository.findAll();	// print
//		allUsers.forEach(user -> System.out.println(user));
		
		// all iterable
//		Iterable<User> allUsers = userRepository.findAll();
//		userRepository.deleteAll(allUsers);
//		allUsers.forEach(user -> System.out.println(user));
		
		//Custom finder method
//		List<User> users = userRepository.findByName("Sanket");
//		users.forEach(u -> System.out.println(u));
		
		List<User> users = userRepository.findByNameAndCity("Sanket", "Pune");
		users.forEach(u -> System.out.println(u));
	}

}
