package com.adopter.app.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.adopter.app.models.entity.PetOrganizationCategory;

public interface POrganizationCategoryRepository extends CrudRepository<PetOrganizationCategory, Long> {

	@Query("SELECT pc FROM PetOrganizationCategory pc WHERE pc.id=:id")
	public PetOrganizationCategory findCategoryById(Long id);
	
	
}
