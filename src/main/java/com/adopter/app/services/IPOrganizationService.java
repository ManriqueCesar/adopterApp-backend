package com.adopter.app.services;

import com.adopter.app.models.dto.AdopterOrganizationDto;
import com.adopter.app.models.dto.PetOrganizationDto;
import com.adopter.app.models.response.ResponseAdopter;
import com.adopter.app.models.response.ResponseModel;
import com.adopter.app.models.response.ResponsePetOrganization;

public interface IPOrganizationService {
	
	public Iterable<PetOrganizationDto> listAll ();
	public ResponseModel register(PetOrganizationDto petOrganization);
	public ResponseAdopter searchAdopter(AdopterOrganizationDto adopterOrganizationDto);
	public ResponsePetOrganization findById(Long idOrganization);
	public ResponseAdopter findAdoptersByIdOrganization(Long idOrganization);
	public ResponsePetOrganization edit(PetOrganizationDto petOrganization);
}