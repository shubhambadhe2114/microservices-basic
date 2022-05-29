package com.example.microservices.VaccinationCenter.Model;

import java.util.List;

import com.example.microservices.VaccinationCenter.Entity.VaccinationCenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CombinedResponse {

	private VaccinationCenter center;
	private List<Citizen> citizens;
	public VaccinationCenter getCenter() {
		return center;
	}
	public void setCenter(VaccinationCenter center) {
		this.center = center;
	}
	public List<Citizen> getCitizens() {
		return citizens;
	}
	public void setCitizens(List<Citizen> citizens) {
		this.citizens = citizens;
	}
}
