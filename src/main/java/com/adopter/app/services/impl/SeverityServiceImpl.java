package com.adopter.app.services.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adopter.app.models.entity.AdopterSeverity;
import com.adopter.app.models.repository.SeverityRepository;
import com.adopter.app.services.ISeverityService;

@Service
public class SeverityServiceImpl implements ISeverityService {

	private final Logger LOGGER = Logger.getLogger(ISeverityService.class.getName());

	@Autowired
	SeverityRepository severityRepo;

	@Override
	public List<AdopterSeverity> listAll() {
		try {
			return (List<AdopterSeverity>) severityRepo.findAll();

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return null;
		}

	}

}