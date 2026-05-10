package com.learning.springbootweb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.learning.springbootweb.anotation.EmployeeRoleAnnotation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long  employeeId;

    @NotBlank(message = "Name of the employee can not be blank !!")
    @Size(min = 3, max = 20)
    private String name;

    @NotBlank(message = "Please fill Email , Employee email can not be blank !!")
    @Email(message = "Please enter a valid email Id")
    private String email;

    @NotNull(message = "Employee age can not be null")
    @Max(value=80,message="age of the Employee can not be more than 80")
    @Min(value = 18,message = "age of the Employee must be greater than 18")
    private Integer age;

//    @NotBlank(message = "Role can not be blank")
//    @Pattern(regexp="^(USER|ADMIN)$",message = "Role of an employee can either be USER or ADMIN")
    @EmployeeRoleAnnotation
    private String role;

    @NotNull(message = "Employee salary cannot be null")
    @Positive(message = "Employee salary must be a positive number")
    @Digits(message = "please enter Employe salary in digits only", integer = 5, fraction = 2)
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "20000.50")
    private Double salary;


    @PastOrPresent(message = "Employee joining date can only be past date or today's date")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "We want only Active users")
    @JsonProperty("isActive")
    private Boolean isActive;

}
