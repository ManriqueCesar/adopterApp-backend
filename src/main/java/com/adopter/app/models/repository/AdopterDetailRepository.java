package com.adopter.app.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.adopter.app.models.entity.AdopterDetail;

public interface AdopterDetailRepository extends CrudRepository<AdopterDetail, Long> {

	@Query("SELECT ad FROM AdopterDetail ad WHERE ad.adopter.id=:idAdopter")
	public AdopterDetail findByIdAdopter(Long idAdopter);
}
