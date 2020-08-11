package org.createtogether.RestControllers;

import java.util.List;

import org.createtogether.Models.Post;

import org.createtogether.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addPosts(@RequestBody Post post) {
		
		return postService.addPosts(post);
	}
	
	@PatchMapping("/patch/{postId}/{category}")
	public ResponseEntity<?> updatePostCategory(@PathVariable("postId") int postId, @PathVariable("category") String category) {

		return postService.updatePostCategory(postId, category);
	}
	
	@GetMapping("/get/unspecified")
	public List<Integer> getUnspecifiedPosts() {
		
		return postService.getUnspecifiedPosts();
	}
	
	@GetMapping("/get/programs")
	public List<Post> getPosts() {
		
		return postService.getPosts();
	}
	
	@GetMapping("/get/events")
	public List<Post> getEvents() {
		
		return postService.getEvents();
	}
	
}
