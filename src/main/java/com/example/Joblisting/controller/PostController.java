package com.example.Joblisting.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Joblisting.PostRepository;
import com.example.Joblisting.model.Post;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class PostController {
	@Autowired
	PostRepository repo;
	
	@Hidden
	@RequestMapping(value="/")
	public void redirect(HttpServletResponse response) throws IOException {
		response.sendRedirect("/swagger-ui.html");
	}
	@GetMapping("/posts")
	public List<Post> getAllPosts(){
		return repo.findAll();
	}
	@PostMapping("/post")
	public Post addPost(@RequestBody Post post) {
		return repo.save(post);
	}
}
