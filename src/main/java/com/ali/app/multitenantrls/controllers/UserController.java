package com.ali.app.multitenantrls.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ali.app.multitenantrls.dto.EmployeeDto;
import com.ali.app.multitenantrls.entities.Employee;
import com.ali.app.multitenantrls.services.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/employees")
    public ResponseEntity<EmployeeDto> createEmployee( @RequestBody EmployeeDto employeeDto) {
        Employee newEmployee = Employee.builder()
            .username(employeeDto.getUsername())
            .build();
        Employee createdEmployee = this.userService.createEmployee(newEmployee);
        EmployeeDto response = new EmployeeDto(createdEmployee.getUsername());
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok().body(this.userService.getAllEmployees());
    }
}
