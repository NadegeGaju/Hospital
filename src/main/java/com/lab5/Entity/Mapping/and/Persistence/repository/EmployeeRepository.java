package com.lab5.Entity.Mapping.and.Persistence.repository;

import com.lab5.Entity.Mapping.and.Persistence.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {

    List<EmployeeModel> findBySurname(String surname);

    List<EmployeeModel> findByAddress(String address);

    List<EmployeeModel> findByTelephone(String telephoneNumber);

    List<EmployeeModel> findBySurnameAndFirstName(String surname, String firstName);
}
