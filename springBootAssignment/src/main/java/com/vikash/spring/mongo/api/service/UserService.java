package com.vikash.spring.mongo.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.vikash.spring.mongo.api.model.User;
import com.vikash.spring.mongo.api.repository.UserRepository;

public class UserService {

	@Autowired
	private UserRepository repository;

	public User saveUser(User user) {
		return repository.save(user);

	}

	public List<User> getUser() {
		return repository.findAll();
	}

	public Optional<User> getUserById(int id) {
		return repository.findById(id);
	}

	public User updateUser(int id, User user) {

		Optional<User> b1 = repository.findById(id);
		User currentUser = b1.get();
		if (currentUser == null) {
			user.setId(id);
			return repository.save(user);
		}

		currentUser.setEmail(user.getEmail());
		currentUser.setUserName(user.getUserName());

		return repository.save(currentUser);
	}

}
