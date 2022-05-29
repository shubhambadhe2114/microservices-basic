package com.example.microservices.CitizenService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.CitizenService.Entity.Citizen;
import com.example.microservices.CitizenService.Repositories.CitizenRepository;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	
	@Autowired
	private CitizenRepository citizenRepo; 

	@GetMapping(path = "/id/{id}")
	public ResponseEntity<List<Citizen>> getByVaccinationCenterId(@PathVariable Integer id) {
		List<Citizen> citizens = citizenRepo.findByVaccinationCenterId(id);
		return new ResponseEntity<>(citizens, HttpStatus.OK);
	}
	
	@PostMapping(path = "/add")
	public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen citizen) {
		Citizen newCitizen = citizenRepo.save(citizen);
		return new ResponseEntity<>(newCitizen, HttpStatus.OK);
	}
}
