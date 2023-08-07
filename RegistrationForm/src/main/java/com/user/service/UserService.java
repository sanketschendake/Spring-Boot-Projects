package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.model.User;
import com.user.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public User storeData(User user)
	{
		User data = repo.save(user);
		return data;
	}

	public User findByEmail(String email) {
		User emailData = repo.findByEmail(email);
		return emailData;
	}
}
