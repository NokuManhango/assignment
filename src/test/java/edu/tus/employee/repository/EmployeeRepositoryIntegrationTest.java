package edu.tus.employee.repository;

import edu.tus.employee.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

@DataJpaTest
class EmployeeRepositoryIntegrationTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee();
        employee.setFirstName("Jane");
        employee.setLastName("Smith");
        employee.setEmailAddress("jane.smith@example.com");
        employee.setAge(28);
        employee.setDepartment("Marketing");
        employee.setDateOfJoining(LocalDate.of(2022, 5, 15));
        employee.setSalary(55000);
    }

    @Test
    void testCreateAndFindEmployee() {
        Employee savedEmployee = employeeRepository.save(employee);

        assertNotNull(savedEmployee.getId());
        assertEquals("Jane", savedEmployee.getFirstName());
        assertEquals("Smith", savedEmployee.getLastName());

        Employee foundEmployee = employeeRepository.findById(savedEmployee.getId()).orElseThrow();
        assertEquals(savedEmployee.getId(), foundEmployee.getId());
        assertEquals("jane.smith@example.com", foundEmployee.getEmailAddress());
    }

    @Test
    void testDeleteEmployee() {
        Employee savedEmployee = employeeRepository.save(employee);

        employeeRepository.deleteById(savedEmployee.getId());
        assertFalse(employeeRepository.findById(savedEmployee.getId()).isPresent());
    }
}
