package com.adopter.app.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.adopter.app.models.entity.Document;

public interface DocumentRepository extends CrudRepository<Document, Long> {

}
