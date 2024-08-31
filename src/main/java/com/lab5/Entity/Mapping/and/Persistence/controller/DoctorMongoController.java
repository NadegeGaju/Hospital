package com.lab5.Entity.Mapping.and.Persistence.controller;

import com.lab5.Entity.Mapping.and.Persistence.model.DoctorMongoModel;
import com.lab5.Entity.Mapping.and.Persistence.service.DoctorMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mongo/doctors")
public class DoctorMongoController {

    @Autowired
    private DoctorMongoService doctorMongoService;

    @PostMapping("/add")
    public DoctorMongoModel addDoctor(@RequestBody DoctorMongoModel doctor) {
        return doctorMongoService.saveDoctor(doctor);
    }

    @GetMapping("/{id}")
    public DoctorMongoModel getDoctor(@PathVariable String id) {
        return doctorMongoService.getDoctor(id);
    }

    @GetMapping("/all")
    public List<DoctorMongoModel> getAllDoctors() {
        return doctorMongoService.getAllDoctors();
    }

    @GetMapping("/job/{speciality}")
    public List<DoctorMongoModel> getDoctorsBySpeciality(@PathVariable String speciality) {
        return doctorMongoService.findDoctorsBySpeciality(speciality);
    }

    @PutMapping("/{id}/address")
    public void updateDoctorAddress(@PathVariable String id, @RequestParam String newAddress) {
        doctorMongoService.updateDoctorAddress(id, newAddress);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable String id) {
        doctorMongoService.deleteDoctor(id);
    }
}
