package org.createtogether.RestControllers;

import java.util.List;

import org.createtogether.Models.ERole;
import org.createtogether.Models.User;
import org.createtogether.Repository.RoleRepository;
import org.createtogether.Repository.UserRepository;
import org.createtogether.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PostMapping("/post/addMod")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		
		return authService.registerUser(user, ERole.ROLE_MODERATOR);
	}
	
	@GetMapping("/get/mods")
	public List<User> getModerators() {
		
		List<User> mods = userRepository.findAllByRolesName(ERole.ROLE_MODERATOR);
		for(int i=0; i < mods.size(); i++) { mods.get(i).setPassword("null"); }
		
		return mods;
	}
	
	@GetMapping("/get/mods/{userId}")
	public User getModerators(@PathVariable("userId") int userId) {
		
		User mod = userRepository.findByIdAndRolesName(userId, ERole.ROLE_MODERATOR);
		mod.setPassword("null");
		
		return mod;
	}
	
}
