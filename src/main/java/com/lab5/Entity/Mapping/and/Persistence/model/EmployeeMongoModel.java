package com.lab5.Entity.Mapping.and.Persistence.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "employees")
public class EmployeeMongoModel {

    @Id
    private String employeeNumber;
    private String surname;
    private String firstName;
    private String address;
    private String telephone;

    // Getters and setters
}
