package com.example.Joblisting.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Joblisting.model.Post;
import com.example.Joblisting.repository.PostRepository;
import com.example.Joblisting.repository.SearchRepository;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {
	@Autowired
	PostRepository repo;
	
	@Autowired
	SearchRepository srepo;
	
	@Hidden
	@RequestMapping(value="/")
	public void redirect(HttpServletResponse response) throws IOException {
		response.sendRedirect("/swagger-ui.html");
	}
	@GetMapping("/allPosts")
	public List<Post> getAllPosts(){
		return repo.findAll();
	}
	@GetMapping("/posts/{text}")
	public List<Post> search(@PathVariable String text){
		return srepo.findByText(text);
	}
	@PostMapping("/post")
	public Post addPost(@RequestBody Post post) {
		return repo.save(post);
	}
}
