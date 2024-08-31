package com.lab5.Entity.Mapping.and.Persistence.repository;

import com.lab5.Entity.Mapping.and.Persistence.model.EmployeeMongoModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeMongoRepository extends MongoRepository<EmployeeMongoModel,String> {
}
