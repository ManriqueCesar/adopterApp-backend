package com.adopter.app.services;

import java.util.ArrayList;

import com.adopter.app.models.dto.AdopterDetailDto;
import com.adopter.app.models.dto.AdopterDto;
import com.adopter.app.models.entity.Adopter;
import com.adopter.app.models.response.ResponseAdopter;
import com.adopter.app.models.response.ResponseModel;

public interface IAdopterService {

	public ResponseModel register (AdopterDto adopter); 
	public ArrayList<Adopter> listAllEnabled ();
	public ResponseModel addComments (AdopterDto adopter);
	public ResponseAdopter getByDocumentNumber (AdopterDto adopter); 
	public ArrayList<AdopterDetailDto> getComments (String docNumber); 
	public ResponseAdopter getAdopterByIdOrganization (Long idOrganization);
	public ResponseAdopter logicalDelete(Long idAdopter);
	public ResponseAdopter delete(Long idAdopter); 
}
