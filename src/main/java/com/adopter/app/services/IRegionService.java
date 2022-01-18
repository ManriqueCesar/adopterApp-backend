package com.adopter.app.services;

import java.util.List;

import com.adopter.app.models.entity.region.Department;
import com.adopter.app.models.entity.region.District;
import com.adopter.app.models.entity.region.Province;

public interface IRegionService {

	public List<District> listDistrict (Long idProvince);
	public List<Department> listDepartment ();
	public List<Province> listProvince (Long idDepartment);
	
}
