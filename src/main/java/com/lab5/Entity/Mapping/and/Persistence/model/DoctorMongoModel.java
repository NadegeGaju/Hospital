package com.lab5.Entity.Mapping.and.Persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "doctors")
public class DoctorMongoModel extends EmployeeMongoModel {

    private String speciality;
    // Getters and setters
}
