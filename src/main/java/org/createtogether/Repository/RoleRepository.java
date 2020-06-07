package org.createtogether.Repository;

import java.util.Optional;

import org.createtogether.Models.ERole;
import org.createtogether.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	Optional<Role> findByName(ERole name);
}
