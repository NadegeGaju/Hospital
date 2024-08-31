package com.lab5.Entity.Mapping.and.Persistence.service;

import com.lab5.Entity.Mapping.and.Persistence.model.DoctorRedisModel;
import com.lab5.Entity.Mapping.and.Persistence.repository.DoctorRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorRedisService {

    @Autowired
    private DoctorRedisRepository doctorRedisRepository;

    public DoctorRedisModel saveDoctor(DoctorRedisModel doctor) {
        return doctorRedisRepository.save(doctor);
    }

    public DoctorRedisModel getDoctor(Long id) {
        return doctorRedisRepository.findById(id).orElse(null);
    }

    public void deleteDoctor(Long id) {
        doctorRedisRepository.deleteById(id);
    }

    public Iterable<DoctorRedisModel> getAllDoctors() {
        return doctorRedisRepository.findAll();
    }
}
