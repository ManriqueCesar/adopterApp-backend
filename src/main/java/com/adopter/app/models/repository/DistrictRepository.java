package com.adopter.app.models.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.adopter.app.models.entity.region.District;

public interface DistrictRepository extends CrudRepository<District, Long> {

	@Query("SELECT d FROM District d WHERE d.province.id =:idProvince")
	public ArrayList<District> findDistritoByIdProvincia(Long idProvince);
	
}
