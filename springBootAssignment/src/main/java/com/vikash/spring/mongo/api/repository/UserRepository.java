package com.vikash.spring.mongo.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vikash.spring.mongo.api.model.User;

public interface UserRepository extends MongoRepository<User, Integer>{

}
