package com.adopter.app.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adopter.app.models.entity.Document;
import com.adopter.app.services.IDocumentService;

@RestController
@RequestMapping("/document")
public class DocumentController {

	@Autowired
	private IDocumentService documentService;
	
	@GetMapping
	public ArrayList<Document> listAll() {
		return (ArrayList<Document>) documentService.listAll();
	}
}
