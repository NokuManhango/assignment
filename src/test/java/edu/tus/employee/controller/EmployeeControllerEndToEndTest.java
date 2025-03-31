package edu.tus.employee.controller;

import edu.tus.employee.errors.ErrorValidation;
import edu.tus.employee.repository.EmployeeRepository;
import edu.tus.employee.controller.EmployeeController;
import edu.tus.employee.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerEndToEndTest {
	
	
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeRepository employeeRepository;
    @MockBean
    private ErrorValidation errorValidation; // Mocking ErrorValidation to avoid dependency issues

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("James");
        employee.setLastName("Bond");
        employee.setEmailAddress("james.bond@example.com");
        employee.setAge(35);
        employee.setDepartment("MI6");
        employee.setDateOfJoining(LocalDate.of(2018, 8, 1));
        employee.setSalary(75000);
    }

    @Test
    void testGetEmployeeById() throws Exception {
        when(employeeRepository.findById(1L)).thenReturn(java.util.Optional.of(employee));

        mockMvc.perform(get("/api/employees/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("James"))
                .andExpect(jsonPath("$.lastName").value("Bond"))
                .andExpect(jsonPath("$.emailAddress").value("james.bond@example.com"));
    }

    @Test
    void testDeleteEmployee() throws Exception {
        when(employeeRepository.findById(1L)).thenReturn(java.util.Optional.of(employee));

        mockMvc.perform(delete("/api/employees/1"))
                .andExpect(status().isNoContent());

        verify(employeeRepository, times(1)).deleteById(1L);
    }
}
