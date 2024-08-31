package com.lab5.Entity.Mapping.and.Persistence.controller;

import com.lab5.Entity.Mapping.and.Persistence.model.DoctorRedisModel;
import com.lab5.Entity.Mapping.and.Persistence.service.DoctorRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorRedisController {

    @Autowired
    private DoctorRedisService doctorRedisService;

    @PostMapping("/add")
    public DoctorRedisModel saveDoctor(@RequestBody DoctorRedisModel doctor) {
        return doctorRedisService.saveDoctor(doctor);
    }

    @GetMapping("/{id}")
    public DoctorRedisModel getDoctor(@PathVariable Long id) {
        return doctorRedisService.getDoctor(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorRedisService.deleteDoctor(id);
    }

    @GetMapping("/all")
    public Iterable<DoctorRedisModel> getAllDoctors() {
        return doctorRedisService.getAllDoctors();
    }
}
