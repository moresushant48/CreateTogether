package org.createtogether.Services;

import org.createtogether.Models.ERole;
import org.createtogether.Models.User;
import org.springframework.http.ResponseEntity;

public interface AuthService {

	public ResponseEntity<?> registerUser(User user, ERole eRole);
	
}
