package org.createtogether.ServicesImpl;

import java.util.HashSet;
import java.util.Set;

import org.createtogether.Models.ERole;
import org.createtogether.Models.Role;
import org.createtogether.Models.User;
import org.createtogether.Repository.RoleRepository;
import org.createtogether.Repository.UserRepository;
import org.createtogether.Security.jwt.MessageResponse;
import org.createtogether.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public ResponseEntity<?> registerUser(User user, ERole eRole) {
		if (userRepository.existsByEmail(user.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User newUser = new User(user.getEmail(), 
				user.getFirstName(), user.getLastName(), user.getMobileno(),
				bCryptPasswordEncoder.encode(user.getPassword()));

		Set<Role> roles = new HashSet<>();
		
		Role userRole = roleRepository.findByName(eRole)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);
		
		newUser.setRoles(roles);
		userRepository.save(newUser);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

}
