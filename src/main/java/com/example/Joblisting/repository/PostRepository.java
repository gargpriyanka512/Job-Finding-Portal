package com.example.Joblisting.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Joblisting.model.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
