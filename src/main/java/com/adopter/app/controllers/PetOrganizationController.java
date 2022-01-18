package com.adopter.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adopter.app.models.dto.AdopterOrganizationDto;
import com.adopter.app.models.dto.PetOrganizationDto;
import com.adopter.app.models.response.ResponseAdopter;
import com.adopter.app.models.response.ResponseModel;
import com.adopter.app.models.response.ResponsePetOrganization;
import com.adopter.app.services.IPOrganizationService;


@RestController
@RequestMapping("/petOrganization")
public class PetOrganizationController {

	@Autowired
	private IPOrganizationService petOrgService;
	
	@GetMapping
	public Iterable<PetOrganizationDto> listAll() {
		return petOrgService.listAll();
	}
	
	@PostMapping("/register")
	public ResponseModel register(@RequestBody PetOrganizationDto petOrganization) {
		return petOrgService.register(petOrganization);
	}
	
	@PostMapping("/search")
	public ResponseAdopter searchAdopter(@RequestBody AdopterOrganizationDto adopterOrganizationDto) {
		return petOrgService.searchAdopter(adopterOrganizationDto);
	}
	
	@GetMapping("/{idOrganization}")
	public ResponsePetOrganization findById(@PathVariable Long idOrganization) {
		return petOrgService.findById(idOrganization);
	}
	
	@GetMapping("/adopter/{idOrganization}")
	public ResponseAdopter findAdoptersByIdOrganization(@PathVariable Long idOrganization) {
		return petOrgService.findAdoptersByIdOrganization(idOrganization);
	}
	
	@PutMapping("/edit")
	public ResponsePetOrganization edit(@RequestBody PetOrganizationDto petOrganization) {
		return petOrgService.edit(petOrganization);
	}
	

	
}
