package com.lab5.Entity.Mapping.and.Persistence.controller;

import com.lab5.Entity.Mapping.and.Persistence.model.DoctorModel;
import com.lab5.Entity.Mapping.and.Persistence.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Create a new doctor
    @PostMapping("add")
    public ResponseEntity<DoctorModel> createDoctor(@RequestBody DoctorModel doctor) {
        DoctorModel savedDoctor = doctorService.saveDoctor(doctor);
        return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorModel> getDoctorById(@PathVariable Long id) {
        DoctorModel doctor = doctorService.getDoctor(id);
        if (doctor != null) {
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<DoctorModel>> getAllDoctors() {
        List<DoctorModel> doctors = doctorService.getAllDoctors();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DoctorModel> updateDoctor(@RequestBody DoctorModel doctor) {
        DoctorModel updatedDoctor = doctorService.updateDoctor(doctor);
        return new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/speciality/{speciality}")
    public ResponseEntity<List<DoctorModel>> getDoctorsBySpeciality(@PathVariable String speciality) {
        List<DoctorModel> doctors = doctorService.getDoctorBySpeciality(speciality);
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }
}
