package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entites.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	//Custom finder method
	List<User> findByName(String name);
	
	List<User> findByNameAndCity(String name, String city);
}
