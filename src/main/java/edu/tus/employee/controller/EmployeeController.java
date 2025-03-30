package edu.tus.employee.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import edu.tus.employee.errors.ErrorMessage;
import edu.tus.employee.errors.ErrorValidation;
import edu.tus.employee.exception.EmployeeException;
import edu.tus.employee.model.Employee;
import edu.tus.employee.repository.EmployeeRepository;

@RestController
@Service
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository empRepository;
	
	
	@Autowired
	ErrorValidation errorValidation;
	
	//TO DO

}



