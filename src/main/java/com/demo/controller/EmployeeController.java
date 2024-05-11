package com.demo.controller;

import com.demo.entity.Country;
import com.demo.entity.Employee;
import com.demo.repository.CountryRepository;
import com.demo.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final CountryRepository countryRepository;

    public EmployeeController(EmployeeRepository employeeRepository, CountryRepository countryRepository) {
        this.employeeRepository = employeeRepository;
        this.countryRepository = countryRepository;
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestParam long id, @RequestBody Employee employee) {


        Country country = countryRepository.findById(id).get();
        employee.setCountry(country);
        Employee saveEmp = employeeRepository.save(employee);
        return ResponseEntity.ok().body(saveEmp);
    }
}
