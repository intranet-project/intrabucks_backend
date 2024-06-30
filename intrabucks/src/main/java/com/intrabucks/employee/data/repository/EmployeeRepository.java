package com.intrabucks.employee.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intrabucks.entity.Employee;

/**
 * 직원(Employee) Repository
 * @author 구은재
 * @version 1.0 
 * 2024-06-30
 **/

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	 @Query("SELECT e FROM Employee e WHERE LOWER(e.empName) LIKE LOWER(CONCAT('%', :empName, '%'))")
	 Page<Employee> findByEmpNameContainingIgnoreCase(String empName, Pageable pageable);
	
}

