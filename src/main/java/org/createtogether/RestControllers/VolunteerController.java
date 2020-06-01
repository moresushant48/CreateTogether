package org.createtogether.RestControllers;

import java.util.List;
import java.util.Optional;

import org.createtogether.Models.Volunteer;
import org.createtogether.Repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VolunteerController {
	
	@Autowired
	VolunteerRepository volunteerRepository;
	
	@GetMapping("/get/volunteers")
	public List<Volunteer> getVolunteers() {
		return volunteerRepository.findAll();
	}
	
	@GetMapping("/get/volunteers/{vid}")
	public Optional<Volunteer> getVolunteer(@PathVariable("vid") int vid) {
		return volunteerRepository.findById(vid);
	}	
	
	@PostMapping("/post/volunteer")
	public Boolean saveVolunteer(@RequestBody Volunteer volunteer) {
	
		if(volunteerRepository.save(volunteer) != null)
			return true;
		
		return false;
	}
	
}