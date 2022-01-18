package com.adopter.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adopter.app.models.entity.AdopterSeverity;
import com.adopter.app.services.ISeverityService;

@RestController
@RequestMapping("/severity")

public class SeverityController {

	@Autowired
	
	private ISeverityService severityService;
	
	@GetMapping
	public List<AdopterSeverity> listAll() {
		return severityService.listAll();
	}

}
