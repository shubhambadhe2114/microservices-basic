package com.example.microservices.VaccinationCenter.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccinationCenter {

	@Id
	private int id;
	
	@Column
	private String centerName;
	@Column
	private String address;
	
}
