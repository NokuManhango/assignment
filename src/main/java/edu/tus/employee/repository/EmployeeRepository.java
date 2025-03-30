package edu.tus.employee.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.tus.employee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	//TO DO
}