package com.lab5.Entity.Mapping.and.Persistence.service;

import com.lab5.Entity.Mapping.and.Persistence.model.DoctorMongoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorMongoService {

    @Autowired
    private MongoTemplate mongoTemplate;

    // Save a document
    public DoctorMongoModel saveDoctor(DoctorMongoModel doctor) {
        return mongoTemplate.save(doctor);
    }

    // Find a document by ID
    public DoctorMongoModel getDoctor(String id) {
        return mongoTemplate.findById(id, DoctorMongoModel.class);
    }

    public List<DoctorMongoModel> getAllDoctors() {
        return mongoTemplate.findAll(DoctorMongoModel.class);
    }

    public List<DoctorMongoModel> findDoctorsBySpeciality(String speciality) {
        Query query = new Query(Criteria.where("speciality").is(speciality));
        return mongoTemplate.find(query, DoctorMongoModel.class);
    }
    public void updateDoctorAddress(String id, String newAddress) {
        Query query = new Query(Criteria.where("employeeNumber").is(id));
        Update update = new Update().set("address", newAddress);
        mongoTemplate.updateFirst(query, update, DoctorMongoModel.class);
    }

    public void deleteDoctor(String id) {
        Query query = new Query(Criteria.where("employeeNumber").is(id));
        mongoTemplate.remove(query, DoctorMongoModel.class);
    }
}
