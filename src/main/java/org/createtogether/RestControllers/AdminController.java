package org.createtogether.RestControllers;

import org.createtogether.Models.ERole;
import org.createtogether.Models.User;
import org.createtogether.Repository.RoleRepository;
import org.createtogether.Repository.UserRepository;
import org.createtogether.Services.AuthService;
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
	AuthService authService;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/addMod")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		
		return authService.registerUser(user, ERole.ROLE_MODERATOR);
	}
	
}
