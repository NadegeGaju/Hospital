package com.lab5.Entity.Mapping.and.Persistence.service;

import com.lab5.Entity.Mapping.and.Persistence.model.DoctorModel;
import com.lab5.Entity.Mapping.and.Persistence.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Transactional
    @CachePut(value = "doctors", key = "#doctor.employeeNumber")
    public DoctorModel saveDoctor(DoctorModel doctor) {
        System.out.println("Saving doctor: " + doctor);
        DoctorModel savedDoctor = doctorRepository.save(doctor);
        System.out.println("Saved doctor: " + savedDoctor);
        return savedDoctor;
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "doctors", key = "#id")
    public DoctorModel getDoctor(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    @Transactional
    @CacheEvict(value = "doctors", key = "#id")
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "doctors")
    public List<DoctorModel> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "doctorsBySpeciality", key = "#speciality")
    public List<DoctorModel> getDoctorBySpeciality(String speciality) {
        return doctorRepository.findDoctorsBySpeciality(speciality);
    }

    @Transactional
    @CachePut(value = "doctors", key = "#doctor.employeeNumber")
    public DoctorModel updateDoctor(DoctorModel doctor) {
        return doctorRepository.save(doctor);
    }
}

