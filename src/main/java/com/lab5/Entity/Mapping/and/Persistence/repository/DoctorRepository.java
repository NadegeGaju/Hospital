package com.lab5.Entity.Mapping.and.Persistence.repository;

import com.lab5.Entity.Mapping.and.Persistence.model.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DoctorRepository extends JpaRepository<DoctorModel, Long> {
    @Query("SELECT d FROM DoctorModel d WHERE d.speciality = :speciality")
    List<DoctorModel> findDoctorsBySpeciality(@Param("speciality") String speciality);
}
