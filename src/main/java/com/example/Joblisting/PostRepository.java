package com.example.Joblisting;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Joblisting.model.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
