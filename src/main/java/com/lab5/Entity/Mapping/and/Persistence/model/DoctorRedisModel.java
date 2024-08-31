package com.lab5.Entity.Mapping.and.Persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("Doctor")
public class DoctorRedisModel implements Serializable {

    @Id
    private Long employeeNumber;
    private String surname;
    private String firstName;
    private String address;
    private String telephone;
    private String speciality;
}
