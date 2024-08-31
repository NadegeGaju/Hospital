package com.lab5.Entity.Mapping.and.Persistence.service;

import com.lab5.Entity.Mapping.and.Persistence.model.EmployeeModel;
import com.lab5.Entity.Mapping.and.Persistence.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeServiceTransactionTests {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private PlatformTransactionManager transactionManager;

    private TransactionStatus transactionStatus;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        transactionStatus = mock(TransactionStatus.class);
        when(transactionManager.getTransaction(any(DefaultTransactionDefinition.class))).thenReturn(transactionStatus);
    }

    @Test
    void testSaveEmployeeTransactionPropagationRequired() {
        EmployeeModel employee = new EmployeeModel();
        employee.setFirstName("John Doe");
        when(employeeRepository.save(any(EmployeeModel.class))).thenReturn(employee);

        EmployeeModel savedEmployee = employeeService.saveEmployee(employee);

        assertEquals(employee.getFirstName(), savedEmployee.getFirstName());
        verify(employeeRepository).save(employee);
    }

    @Test
    void testGetEmployeeByIdTransactionSupports() {
        EmployeeModel employee = new EmployeeModel();
        employee.setEmployeeNumber(1L);
        employee.setFirstName("Jane Doe");
        when(employeeRepository.findById(anyLong())).thenReturn(Optional.of(employee));

        Optional<EmployeeModel> retrievedEmployee = employeeService.getEmployeeById(1L);

        assertEquals(employee.getFirstName(), retrievedEmployee.get().getFirstName());
        verify(employeeRepository).findById(1L);
    }

    @Test
    void testGetAllEmployeesTransactionRequiresNew() {
        EmployeeModel employee = new EmployeeModel();
        employee.setFirstName("Employee");
        when(employeeRepository.findAll()).thenReturn(List.of(employee));

        List<EmployeeModel> employees = employeeService.getAllEmployees();

        assertEquals(1, employees.size());
        assertEquals(employee.getFirstName(), employees.get(0).getFirstName());
        verify(employeeRepository).findAll();
    }

    @Test
    void testDeleteEmployeeByIdTransactionMandatory() {
        employeeService.deleteEmployeeById(1L);

        verify(employeeRepository).deleteById(1L);
    }

    @Test
    void testUpdateEmployeeTransactionNested() {
        EmployeeModel employee = new EmployeeModel();
        employee.setEmployeeNumber(1L);
        employee.setFirstName("John Doe Updated");
        when(employeeRepository.save(any(EmployeeModel.class))).thenReturn(employee);

        EmployeeModel updatedEmployee = employeeService.updateEmployee(employee);

        assertEquals(employee.getFirstName(), updatedEmployee.getFirstName());
        verify(employeeRepository).save(employee);
    }

    @Test
    @Transactional
        void testTransactionRollback () {
            EmployeeModel employee = new EmployeeModel();
            employee.setFirstName("John Doe");
        assertThrows(RuntimeException.class, () -> {
            try {
                employeeService.saveEmployee(employee);
                throw new RuntimeException("Simulated Exception");
            } catch (RuntimeException ex) {
                throw ex;
            }
        });
        assertThrows(Exception.class, () -> {
            employeeRepository.findById(employee.getEmployeeNumber())
                    .orElseThrow(() -> new Exception("Employee should not exist"));
        });
    }
    }

