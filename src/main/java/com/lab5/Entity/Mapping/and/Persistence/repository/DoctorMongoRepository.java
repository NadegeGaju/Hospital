package com.lab5.Entity.Mapping.and.Persistence.repository;

import com.lab5.Entity.Mapping.and.Persistence.model.DoctorMongoModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorMongoRepository extends MongoRepository<DoctorMongoModel, String> {
}
