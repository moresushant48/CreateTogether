package org.createtogether.ServicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.createtogether.Models.Category;
import org.createtogether.Models.ECategory;
import org.createtogether.Models.Post;
import org.createtogether.Models.User;
import org.createtogether.Repository.CategoryRepository;
import org.createtogether.Repository.PostRepository;
import org.createtogether.Repository.RoleRepository;
import org.createtogether.Repository.UserRepository;
import org.createtogether.Security.jwt.MessageResponse;
import org.createtogether.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@Override
	public ResponseEntity<?> addPosts(Post post) {
		
		post.setCategory(categoryRepository.findByctgTitle(ECategory.UNSPECIFIED).get());
		
		User user = userRepository.getOne(Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName()));
		if (user!=null) post.setPostUser(user);
		else return ResponseEntity.badRequest().body(new MessageResponse("Something went wrong..! Please login again."));
		
		if(postRepository.save(post) != null)
			return ResponseEntity.ok(new MessageResponse("Blog has been sent. Wait for Approval."));
		
		return ResponseEntity.badRequest().body(new MessageResponse("Couldn't process your post."));
	}

	@Override
	public ResponseEntity<?> updatePostCategory(int postId, String category) {
		
		Post post = postRepository.getOne(postId);
		
		if(post!=null) {
			
			post.setPostPublished(false);
			
			if(category.equalsIgnoreCase(ECategory.EVENTS.toString()))
				post.setCategory(categoryRepository.findByctgTitle(ECategory.EVENTS).get());
			else if (category.equalsIgnoreCase(ECategory.PROGRAMS.toString())) 
					post.setCategory(categoryRepository.findByctgTitle(ECategory.PROGRAMS).get());
				else {
					post.setCategory(categoryRepository.findByctgTitle(ECategory.UNSPECIFIED).get());
					post.setPostPublished(false);
				}
			
			if(postRepository.save(post)!= null) {
				return ResponseEntity.ok(new MessageResponse("Post category updated."));
			}
			
		}else return ResponseEntity.badRequest().body(new MessageResponse("Couldn't find post."));
		
		return ResponseEntity.badRequest().body(new MessageResponse("Couldn't update category."));

	}

	@Override
	public List<Integer> getUnspecifiedPosts() {
		
		Category unspecified = categoryRepository.findByctgTitle(ECategory.UNSPECIFIED).get();
		
		try {
			User user = userRepository.getOne(Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName()));
			if(user!=null) {
				if(user.getRoles().contains(roleRepository.getOne(1))) 
					return postRepository.getIdsByCategory(unspecified).get();
			}
		}catch (NoSuchElementException e) {
			System.out.println("No Pending Articles Found.");
		}
		
		return new ArrayList<Integer>();
	}

	@Override
	public List<Post> getPosts() {
		
		Category programs = categoryRepository.findByctgTitle(ECategory.PROGRAMS).get();
		
		try {
			User user = userRepository.getOne(Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName()));
			if(user!=null) {
				if(user.getRoles().contains(roleRepository.getOne(1))) {
					return postRepository.findAllByCategory(programs).get();
				} else
					return postRepository.findAllBypostUserIdAndCategory(user.getId(), programs).get();
			}
		}catch (NoSuchElementException e) {
			System.out.println("No Programs Found.");
		}
		
		return new ArrayList<Post>();
	}

	@Override
	public List<Post> getEvents() {
		
		Category events = categoryRepository.findByctgTitle(ECategory.EVENTS).get();
		
		try {
			User user = userRepository.getOne(Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName()));
			if(user!=null) {
				if(user.getRoles().contains(roleRepository.getOne(1))) {
					return postRepository.findAllByCategory(events).get();
				} else
					return postRepository.findAllBypostUserIdAndCategory(user.getId(), events).get();
			}
		}catch (NoSuchElementException e) {
			System.out.println("No Events Found.");
		}
		return new ArrayList<Post>();
	}	
	
}
