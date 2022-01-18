package com.adopter.app.models.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.adopter.app.models.dto.PetOrganizationDto;
import com.adopter.app.models.entity.PetOrganization;

public interface POrganizationRepository extends CrudRepository<PetOrganization, Long> {

	@Query("SELECT new com.adopter.app.models.dto.PetOrganizationDto(p) FROM PetOrganizationDetail p")
	public ArrayList<PetOrganizationDto> listAll();
	
	@Query("SELECT p FROM PetOrganization p WHERE p.id=:idOrganization")
	public PetOrganization getPetOrganizationById(Long idOrganization);
	
	@Query("SELECT new com.adopter.app.models.dto.PetOrganizationDto(pd) FROM PetOrganizationDetail pd WHERE pd.petOrganization.name=:name")
	public String findByName(String name);
	
	@Query("SELECT pd.attemptsAvailable FROM PetOrganizationDetail pd WHERE pd.petOrganization.id=:idOrganization")
	public Integer getAttemptsByIdOrganization(Long idOrganization);
	
	@Query("SELECT new com.adopter.app.models.dto.PetOrganizationDto(pd) FROM PetOrganizationDetail pd WHERE pd.petOrganization.id=:idOrganization")
	public PetOrganizationDto getStatusByIdOrganization(Long idOrganization);
	
	@Query("SELECT new com.adopter.app.models.dto.PetOrganizationDto(pd) FROM PetOrganizationDetail pd WHERE pd.petOrganization.id=:idOrganization")
	public ArrayList<PetOrganizationDto> findPetOrganizationById(Long idOrganization);
	
	@Procedure("sp_updateAttempts")
	public String updateAttempts(@Param("idOrganization") Long idOrganization);
	
}
