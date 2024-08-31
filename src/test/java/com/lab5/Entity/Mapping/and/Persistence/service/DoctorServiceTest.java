package com.lab5.Entity.Mapping.and.Persistence.service;

import com.lab5.Entity.Mapping.and.Persistence.model.DoctorModel;
import com.lab5.Entity.Mapping.and.Persistence.repository.DoctorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
public class DoctorServiceTest {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorService doctorService;

    @BeforeEach
    public void setUp() {
        doctorRepository.deleteAll();

        // Seed data
        DoctorModel doctor = new DoctorModel();
        doctor.setEmployeeNumber(1L);
        doctor.setSurname("Smith");
        doctor.setFirstName("John");
        doctor.setAddress("123 Main St");
        doctor.setTelephone("555-1234");
        doctor.setSpeciality("Cardiologist");
        doctorRepository.save(doctor);
    }

    @Test
    public void testSaveDoctor() {
        DoctorModel doctor = new DoctorModel();
        doctor.setSurname("Aime");
        doctor.setFirstName("Anna");
        doctor.setAddress("456 Elm St");
        doctor.setTelephone("555-5678");
        doctor.setSpeciality("Neurologist");

        DoctorModel savedDoctor = doctorService.saveDoctor(doctor);
        assertThat(savedDoctor).isNotNull();
        assertThat(savedDoctor.getSurname()).isEqualTo("Aime");
        assertThat(savedDoctor.getFirstName()).isEqualTo("Anna");
        assertThat(savedDoctor.getAddress()).isEqualTo("456 Elm St");
        assertThat(savedDoctor.getTelephone()).isEqualTo("555-5678");
        assertThat(savedDoctor.getSpeciality()).isEqualTo("Neurologist");
    }

    @Test
    public void testGetDoctor() {
        DoctorModel doctor = doctorService.getDoctor(1L);
        assertThat(doctor).isNotNull();
        assertThat(doctor.getSurname()).isEqualTo("Smith");
        assertThat(doctor.getFirstName()).isEqualTo("John");
        assertThat(doctor.getAddress()).isEqualTo("123 Main St");
        assertThat(doctor.getTelephone()).isEqualTo("555-1234");
        assertThat(doctor.getSpeciality()).isEqualTo("Cardiologist");
    }

    @Test
    public void testDeleteDoctor() {
        doctorService.deleteDoctor(1L);
        assertThat(doctorService.getDoctor(1L)).isNull();
    }

    @Test
    public void testGetAllDoctors() {
        List<DoctorModel> doctors = doctorService.getAllDoctors();
        assertThat(doctors).isNotEmpty();
    }
}
