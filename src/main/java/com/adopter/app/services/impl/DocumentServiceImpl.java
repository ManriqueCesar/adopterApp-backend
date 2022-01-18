package com.adopter.app.services.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adopter.app.models.entity.Document;
import com.adopter.app.models.repository.DocumentRepository;
import com.adopter.app.services.IDocumentService;



@Service
public class DocumentServiceImpl implements IDocumentService {

	private final Logger LOGGER = Logger.getLogger(IDocumentService.class.getName());

	@Autowired
	DocumentRepository documentRepo;

	@Override
	public List<Document> listAll() {
		try {
			return (List<Document>) documentRepo.findAll();

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return null;
		}

	}

}