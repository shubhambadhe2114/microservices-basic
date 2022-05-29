package com.example.microservices.VaccinationCenter.Controller;

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
import org.springframework.web.client.RestTemplate;

import com.example.microservices.VaccinationCenter.Entity.VaccinationCenter;
import com.example.microservices.VaccinationCenter.Model.Citizen;
import com.example.microservices.VaccinationCenter.Model.CombinedResponse;
import com.example.microservices.VaccinationCenter.Repositories.VaccinationCenterRepo;


@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {
	
	@Autowired
	private VaccinationCenterRepo centerRepo;
	
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping(path = "/add")
	public ResponseEntity<VaccinationCenter> add(@RequestBody VaccinationCenter newCenter) {
		VaccinationCenter center = centerRepo.save(newCenter);
		return new ResponseEntity<VaccinationCenter>(center, HttpStatus.OK);
	}
	
	@GetMapping(path = "/centerId/{centerId}")
	public ResponseEntity<CombinedResponse> getAllDataBasedOnCenterId(@PathVariable Integer centerId) {
		CombinedResponse response = new CombinedResponse();
		response.setCenter(centerRepo.findById(centerId).get());
		List<Citizen> citizens = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/"+centerId, List.class);
		response.setCitizens(citizens);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
}
