package com.lab5.Entity.Mapping.and.Persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="patient")
public class PatientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientNumber;

    private String name;
    private String surname;
    private String address;
    private String telephone;

    // Getters and Setters
}
