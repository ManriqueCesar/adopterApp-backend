package com.adopter.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adopter.app.models.entity.region.Department;
import com.adopter.app.models.entity.region.District;
import com.adopter.app.models.entity.region.Province;
import com.adopter.app.services.IRegionService;

@RestController
@RequestMapping("/region")
public class RegionController {

	@Autowired
	private IRegionService regionService;
	
	@GetMapping("/department")
	public List<Department> listDepartment() {
		return regionService.listDepartment();
	}
	
	@GetMapping("/province/{idDepartment}")
	public List<Province> listProvince(@PathVariable Long idDepartment ) {
		return regionService.listProvince(idDepartment);
	}
	
	@GetMapping("/district/{idProvince}")
	public List<District> listDistrict(@PathVariable Long idProvince) {
		return regionService.listDistrict(idProvince);
	}
}
