package com.user.repo;

import org.springframework.data.repository.CrudRepository;

import com.user.entites.Login;

public interface LoginRepository extends CrudRepository<Login, Long>{

	Login findByUsernameAndPassword(String userName, String password); 
}
