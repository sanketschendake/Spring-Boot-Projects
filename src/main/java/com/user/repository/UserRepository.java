package com.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.user.model.User;
import java.util.List;


public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findByEmail(String email);
}
