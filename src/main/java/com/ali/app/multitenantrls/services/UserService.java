package com.ali.app.multitenantrls.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ali.app.multitenantrls.entities.Employee;
import com.ali.app.multitenantrls.repositories.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

    private final EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee userNeedToBeCreated) {
        Employee createdEmployee = employeeRepository.save(userNeedToBeCreated);
        return createdEmployee;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
        
    

}
