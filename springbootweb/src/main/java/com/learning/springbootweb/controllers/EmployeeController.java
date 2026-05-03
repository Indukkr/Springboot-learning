package com.learning.springbootweb.controllers;

import com.learning.springbootweb.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping("/employees/{employeeId}")

    public EmployeeDTO getEmployeeById(@PathVariable("employeeId") Long employeeId) {
        return new EmployeeDTO(employeeId,"indu","indu@gamil.com",30, LocalDate.of(2026,4,1),true);
    }

    @GetMapping
    public String getAllEmployees(@RequestParam(required = false) Integer age,
                                  @RequestParam(required = false) String sortBy){
        return "age " + 30 + " " +sortBy;
    }

//    @PostMapping
//    public String createNewEmployee(){
//        return "Hello from POST";
//    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO inputEmployee) {
        inputEmployee.setId(10L);
        return inputEmployee;
    }

    @PutMapping
    public String updateEmployee(){
        return "Hello from PUT";
    }
}
