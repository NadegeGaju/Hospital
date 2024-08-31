package com.lab5.Entity.Mapping.and.Persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="department")
public class DepartmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    private String name;
    private String building;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private DoctorModel director;

    @OneToMany(mappedBy = "department")
    private List<WardModel> wards;

    // Getters and setters
}

