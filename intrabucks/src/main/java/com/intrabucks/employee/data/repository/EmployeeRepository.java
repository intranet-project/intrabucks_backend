package com.intrabucks.employee.data.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.intrabucks.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
	 Page<Employee> findByEmpNameContainingIgnoreCase(String empName, Pageable pageable);

	 @Query("SELECT e FROM Employee e WHERE LOWER(e.empName) LIKE LOWER(CONCAT('%', :empName, '%'))")
	    Page<Employee> searchEmployeesByName(@Param("empName") String empName, Pageable pageable);
}

