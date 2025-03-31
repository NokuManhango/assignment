package edu.tus.employee.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

class EmployeeUnitTest {

    @Test
    void testEmployeeGettersAndSetters() {
        Employee employee = new Employee();

        employee.setId(1L);
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setEmailAddress("john.doe@example.com");
        employee.setAge(30);
        employee.setDepartment("Engineering");
        employee.setDateOfJoining(LocalDate.of(2020, 1, 1));
        employee.setSalary(50000);

        assertEquals(1L, employee.getId());
        assertEquals("John", employee.getFirstName());
        assertEquals("Doe", employee.getLastName());
        assertEquals("john.doe@example.com", employee.getEmailAddress());
        assertEquals(30, employee.getAge());
        assertEquals("Engineering", employee.getDepartment());
        assertEquals(LocalDate.of(2020, 1, 1), employee.getDateOfJoining());
        assertEquals(50000, employee.getSalary());
    }
}
