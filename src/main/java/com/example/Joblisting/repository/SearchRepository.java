package com.example.Joblisting.repository;

import java.util.List;

import com.example.Joblisting.model.Post;

public interface SearchRepository {
	List<Post> findByText(String text);

}
