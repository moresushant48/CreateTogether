package org.createtogether.Repository;

import java.util.List;
import java.util.Optional;

import org.createtogether.Models.Category;
import org.createtogether.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Integer>{

	@Query("SELECT p.postId from Post p WHERE p.category = ?1")
	Optional<List<Integer>> getIdsByCategory(Category category);
	
	Optional<List<Post>> findAllByCategory(Category category);
	
	Optional<List<Post>> findAllBypostUserIdAndCategory(int userId, Category category);
}
