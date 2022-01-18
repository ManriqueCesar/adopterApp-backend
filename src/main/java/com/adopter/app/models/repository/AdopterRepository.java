package com.adopter.app.models.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.adopter.app.models.dto.AdopterDetailDto;
import com.adopter.app.models.dto.AdopterDto;
import com.adopter.app.models.entity.Adopter;

public interface AdopterRepository extends CrudRepository<Adopter, Long> {

	@Query("SELECT new com.adopter.app.models.dto.AdopterDto(a) FROM AdopterDetail a WHERE (a.adopter.docNumber=:number) AND (a.adopter.status=1)")
	public ArrayList<AdopterDto> findAdopterByNumberDoc(String number);
	
	@Query("SELECT new com.adopter.app.models.dto.AdopterDto(a) FROM AdopterDetail a WHERE a.petOrganization.id=:idOrganization")
	public ArrayList<AdopterDto> getAdopterByIdOrganization(Long idOrganization);

	@Query("SELECT new com.adopter.app.models.dto.AdopterDetailDto(ad) FROM AdopterDetail ad WHERE ad.adopter.docNumber=:number")
	public ArrayList<AdopterDetailDto> getCommentsByNumberDoc(String number);
	
	@Query("SELECT a FROM Adopter a WHERE a.status=1")
	public ArrayList<Adopter> listEnabledAdopters();
	
}
