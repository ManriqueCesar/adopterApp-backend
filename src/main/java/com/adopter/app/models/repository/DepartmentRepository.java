package com.adopter.app.models.repository;

import org.springframework.data.repository.CrudRepository;
import com.adopter.app.models.entity.region.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

}
