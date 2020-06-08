package org.createtogether.RestControllers;

import java.util.HashSet;
import java.util.Set;

import org.createtogether.Models.ERole;
import org.createtogether.Models.Role;
import org.createtogether.Models.User;
import org.createtogether.Repository.RoleRepository;
import org.createtogether.Repository.UserRepository;
import org.createtogether.Security.jwt.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/addMod")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		
		if (userRepository.existsByEmail(user.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User newUser = new User(user.getEmail(), 
				user.getUsername(),
				bCryptPasswordEncoder.encode(user.getPassword()));

		Set<Role> roles = new HashSet<>();
		
		Role userRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);
		
		newUser.setRoles(roles);
		userRepository.save(newUser);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
}
