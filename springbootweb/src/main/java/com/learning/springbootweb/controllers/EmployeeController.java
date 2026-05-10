package com.learning.springbootweb.controllers;

import com.learning.springbootweb.dto.EmployeeDTO;
import com.learning.springbootweb.entities.EmployeeEntity;
import com.learning.springbootweb.exceptions.ResourceNotFoundException;
import com.learning.springbootweb.repositories.EmployeeRepository;
import com.learning.springbootweb.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("employeeId") Long employeeId) {

        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(employeeId);
        return employeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found with Id : " + employeeId));

    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false) Integer age,
                                             @RequestParam(required = false) String sortBy){
        return employeeService.getAllEmployees();
    }

//    @PostMapping
//    public String createNewEmployee(){
//        return "Hello from POST";
//    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody @Valid EmployeeDTO inputEmployee) {
                EmployeeDTO savedEmployee = employeeService.createEmployee(inputEmployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody @Valid EmployeeDTO employeeDTO,
                                                          @PathVariable Long employeeId){
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeDTO,employeeId));
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long employeeId){
        boolean gotDeleted = employeeService.deleteEmployeeById(employeeId);
             if(gotDeleted) return ResponseEntity.ok(true);
             return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeDetailById(@RequestBody Map<String, Object> updates,
                                                       @PathVariable Long employeeId){
        EmployeeDTO employeeDTO = employeeService.updatePartialEmployeeDetailById(updates,employeeId);
        if (employeeDTO == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(employeeDTO);
    }
}
