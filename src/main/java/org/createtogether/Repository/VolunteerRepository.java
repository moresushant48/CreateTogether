package org.createtogether.Repository;

import org.createtogether.Models.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolunteerRepository extends JpaRepository<Volunteer, Integer> {
	
}
