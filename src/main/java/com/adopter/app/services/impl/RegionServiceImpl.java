package com.adopter.app.services.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adopter.app.models.entity.region.Department;
import com.adopter.app.models.entity.region.District;
import com.adopter.app.models.entity.region.Province;
import com.adopter.app.models.repository.DepartmentRepository;
import com.adopter.app.models.repository.DistrictRepository;
import com.adopter.app.models.repository.ProvinceRepository;
import com.adopter.app.services.IRegionService;
import com.adopter.app.services.ISeverityService;

@Service
public class RegionServiceImpl implements IRegionService {

	private final Logger LOGGER = Logger.getLogger(ISeverityService.class.getName());

	@Autowired
	DepartmentRepository departmentRepo;

	@Autowired
	ProvinceRepository provinceRepo;

	@Autowired
	DistrictRepository districtRepo;

	@Override
	public List<Department> listDepartment() {
		try {
			return (List<Department>) departmentRepo.findAll();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return null;
		}
	}

	@Override
	public List<Province> listProvince(Long idDepartment) {
		try {
			System.out.println(idDepartment);
			return provinceRepo.findProvinciaByIdDepartment(idDepartment);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return null;
		}
	}

	@Override
	public List<District> listDistrict(Long idProvince) {
		try {
			return districtRepo.findDistritoByIdProvincia(idProvince);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return null;
		}
	}
}
