package com.vikash.spring.mongo.api.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vikash.spring.mongo.api.model.User;
import com.vikash.spring.mongo.api.service.UserService;

@RestController
public class UserController {
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService service;

	@PostMapping(value = "/api/user/addUser")
	public User addUser(@RequestBody User user) {
		return service.saveUser(user);

	}

	@GetMapping(value = "/api/user/findAllUser")
	public List<User> findAllUser() {
		return service.getUser();
	}

	@GetMapping(value = "/api/user/findUserById/{id}")
	public Optional<User> findUserById(@PathVariable int id) {
		return service.getUserById(id);
	}

	@PutMapping(value = "/api/user/update/{id}")
	public User update(@PathVariable("id") int id, @RequestBody User user) {
		return service.updateUser(id, user);

	}

}
