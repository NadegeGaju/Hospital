package com.lab5.Entity.Mapping.and.Persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="hospitalization")
public class HospitalizationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientModel patient;

    @ManyToOne
    @JoinColumn(name = "ward_id")
    private WardModel ward;

    private int bedNumber;
    private String diagnosis;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorModel treatingDoctor;
}