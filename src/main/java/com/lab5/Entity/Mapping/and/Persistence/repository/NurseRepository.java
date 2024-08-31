package com.lab5.Entity.Mapping.and.Persistence.repository;

import com.lab5.Entity.Mapping.and.Persistence.model.NurseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NurseRepository extends JpaRepository<NurseModel, Long> {
}

