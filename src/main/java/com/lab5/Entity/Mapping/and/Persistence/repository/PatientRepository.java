package com.lab5.Entity.Mapping.and.Persistence.repository;

import com.lab5.Entity.Mapping.and.Persistence.model.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PatientRepository extends JpaRepository<PatientModel, Long> {
    List<PatientModel> findBySurname(String surname);

}
