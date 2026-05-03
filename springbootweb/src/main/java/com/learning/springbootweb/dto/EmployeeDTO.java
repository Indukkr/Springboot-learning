package com.learning.springbootweb.dto;

import java.time.LocalDate;

public class EmployeeDTO {
    private Long  employeeId;
    private String name;
    private String email;
    private Integer age;
    private LocalDate dateOfJoining;
    private Boolean active;

    public EmployeeDTO() {
    }
    public EmployeeDTO(Long id, String name, String email, Integer age, LocalDate dateOfJoining, Boolean active) {
        this.employeeId = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.dateOfJoining = dateOfJoining;
        this.active = active;

    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return employeeId;
    }

    public void setId(Long id) {
        this.employeeId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
