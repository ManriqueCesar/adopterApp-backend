package com.adopter.app.models.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.adopter.app.models.entity.region.Province;

public interface ProvinceRepository extends CrudRepository<Province, Long> {

	@Query("SELECT p FROM Province p WHERE p.department.id=:idDepartment")
	public ArrayList<Province> findProvinciaByIdDepartment(Long idDepartment);
	
}
