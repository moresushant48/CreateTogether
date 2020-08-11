package org.createtogether.Services;

import java.util.List;

import org.createtogether.Models.Post;
import org.springframework.http.ResponseEntity;

public interface PostService {

	public ResponseEntity<?> addPosts(Post post);
	
	public ResponseEntity<?> updatePostCategory(int postId, String category);
	
	public List<Integer> getUnspecifiedPosts();
	
	public List<Post> getPosts();
	
	public List<Post> getEvents();
	
}
