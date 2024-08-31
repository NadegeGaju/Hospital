package com.lab5.Entity.Mapping.and.Persistence.repository;

import com.lab5.Entity.Mapping.and.Persistence.model.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentModel, Long> {

    List<DepartmentModel> findByName(String name);

    List<DepartmentModel> findByBuilding(String building);
}
