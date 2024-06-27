package com.intrabucks.employee.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intrabucks.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
