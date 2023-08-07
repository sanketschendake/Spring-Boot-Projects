package com.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entites.Login;
import com.user.repo.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository repo;

	public Login login(String username, String password) {
		Login user = repo.findByUsernameAndPassword(username, password);
		return user;
	}

}