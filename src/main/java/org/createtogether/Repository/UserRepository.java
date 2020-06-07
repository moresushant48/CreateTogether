package org.createtogether.Repository;

import java.util.Optional;

import org.createtogether.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	Boolean existsByEmail(String email);
	
	Optional<User> findByEmail(String email);

}
