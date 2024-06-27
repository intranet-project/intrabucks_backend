package com.intrabucks.employee.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intrabucks.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
