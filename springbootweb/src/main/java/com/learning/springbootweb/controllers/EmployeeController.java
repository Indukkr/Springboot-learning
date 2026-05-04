package com.learning.springbootweb.controllers;

import com.learning.springbootweb.dto.EmployeeDTO;
import com.learning.springbootweb.entities.EmployeeEntity;
import com.learning.springbootweb.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable("employeeId") Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false) Integer age,
                                                @RequestParam(required = false) String sortBy){
        return employeeRepository.findAll();
    }

//    @PostMapping
//    public String createNewEmployee(){
//        return "Hello from POST";
//    }

    @PostMapping
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity inputEmployee) {

        return employeeRepository.save(inputEmployee);
    }

    @PutMapping
    public String updateEmployee(){
        return "Hello from PUT";
    }
}
