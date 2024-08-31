package com.lab5.Entity.Mapping.and.Persistence.service;

import com.lab5.Entity.Mapping.and.Persistence.model.EmployeeModel;
import com.lab5.Entity.Mapping.and.Persistence.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public EmployeeModel saveEmployee(EmployeeModel employee) {
        return employeeRepository.save(employee);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, isolation = Isolation.READ_COMMITTED)
    public Optional<EmployeeModel> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ, readOnly = true)
    public List<EmployeeModel> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Transactional(propagation = Propagation.MANDATORY, isolation = Isolation.READ_COMMITTED)
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Transactional(propagation = Propagation.NESTED, isolation = Isolation.SERIALIZABLE)
    public EmployeeModel updateEmployee(EmployeeModel employee) {
        return employeeRepository.save(employee);
    }
}
