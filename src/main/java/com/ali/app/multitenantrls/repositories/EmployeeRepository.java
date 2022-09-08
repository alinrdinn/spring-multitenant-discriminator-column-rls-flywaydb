package com.ali.app.multitenantrls.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ali.app.multitenantrls.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
