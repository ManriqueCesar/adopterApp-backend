package com.adopter.app.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.adopter.app.models.entity.AdopterSeverity;

public interface SeverityRepository extends CrudRepository<AdopterSeverity, Long> {

}
