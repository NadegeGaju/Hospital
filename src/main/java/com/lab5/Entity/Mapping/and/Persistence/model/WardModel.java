package com.lab5.Entity.Mapping.and.Persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ward")
public class WardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;
    private int beds;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private NurseModel supervisor;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentModel department;
}
