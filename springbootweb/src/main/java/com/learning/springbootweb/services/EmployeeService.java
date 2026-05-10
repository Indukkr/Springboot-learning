package com.learning.springbootweb.services;

import com.learning.springbootweb.dto.EmployeeDTO;
import com.learning.springbootweb.entities.EmployeeEntity;
import com.learning.springbootweb.exceptions.ResourceNotFoundException;
import com.learning.springbootweb.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id) {
//        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
//        return  modelMapper.map(employeeEntity,EmployeeDTO.class);
        return employeeRepository.findById(id)
                .map(employeeEntity -> modelMapper
                        .map(employeeEntity,EmployeeDTO.class));

    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity ->modelMapper.map(employeeEntity,EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO createEmployee(EmployeeDTO inputEmployee) {
        EmployeeEntity toSaveEmployeeEntity = modelMapper.map(inputEmployee,EmployeeEntity.class);
        EmployeeEntity saveEmployeeEntity = employeeRepository.save(toSaveEmployeeEntity);
        return modelMapper.map(saveEmployeeEntity,EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployeeById(EmployeeDTO employeeDTO, Long employeeId) {
        isExistByEmployeeId(employeeId);
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO,EmployeeEntity.class);
        employeeEntity.setEmployeeId(employeeId);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    public void isExistByEmployeeId(Long employeeId){
        boolean exist = employeeRepository.existsById(employeeId);
        if(!exist) throw new ResourceNotFoundException("Employee with id"+employeeId+"not into the database");
    }
    public boolean  deleteEmployeeById(Long employeeId) {
        isExistByEmployeeId(employeeId);
        employeeRepository.deleteById(employeeId);
        return true;
    }

    public EmployeeDTO updatePartialEmployeeDetailById(Map<String, Object> updates, Long employeeId) {
        isExistByEmployeeId(employeeId);
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
        updates.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findRequiredField(EmployeeEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
        });
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);

    }
}
