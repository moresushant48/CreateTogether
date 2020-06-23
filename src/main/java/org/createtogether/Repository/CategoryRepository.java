package org.createtogether.Repository;

import java.util.Optional;

import org.createtogether.Models.Category;
import org.createtogether.Models.ECategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Optional<Category> findByctgTitle(ECategory name);
	
}
