package com.adopter.app.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adopter.app.models.dto.AdopterDetailDto;
import com.adopter.app.models.dto.AdopterDto;
import com.adopter.app.models.entity.Adopter;
import com.adopter.app.models.response.ResponseAdopter;
import com.adopter.app.models.response.ResponseModel;
import com.adopter.app.services.IAdopterService;

@RestController
@RequestMapping("/adopter")
public class AdopterController {

	@Autowired
	private IAdopterService adopterService;
	
	@GetMapping
	public ArrayList<Adopter> listAllEnabled() {
		return adopterService.listAllEnabled();
	}
	
	@GetMapping("/comments/{docNumber}")
	public ArrayList<AdopterDetailDto> getComments(@PathVariable String docNumber) {
		return adopterService.getComments(docNumber);
	}
	
	@GetMapping("/{idOrganization}")
	public ResponseAdopter getAdopterByIdOrganization(@PathVariable Long idOrganization) {
		return adopterService.getAdopterByIdOrganization(idOrganization);
	}
	
	@PostMapping("/register")
	public ResponseModel register(@RequestBody AdopterDto filter) {
		return adopterService.register(filter);
	}
	
	@PostMapping("/addComments")
	public ResponseModel addComments(@RequestBody AdopterDto filter) {
		return adopterService.addComments(filter);
	}
	
	@GetMapping("/detail/{docNumber}")
	public ResponseAdopter getByDocumentNumber(@PathVariable String docNumber) {
		return adopterService.getByDocumentNumber(docNumber);
	}
	
	@PutMapping("/logicalDelete/{idAdopter}")
	public ResponseAdopter logicalDelete(@PathVariable Long idAdopter) {
		return adopterService.logicalDelete(idAdopter);
	}
	
	@DeleteMapping("/delete/{idAdopter}")
	public ResponseAdopter delete(@PathVariable Long idAdopter) {
		return adopterService.delete(idAdopter);
	}
	
	
}
