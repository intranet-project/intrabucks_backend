package com.intrabucks.employee.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.intrabucks.entity.Department;

/**
 * 직원(Department) Repository
 * @author 구은재
 * @version 1.0 
 * 2024-06-30
 **/

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	@Query("SELECT d FROM Department d WHERE d.deptCode = :deptCode")
	Optional<Department> findByDeptCode(String deptCode);
	
	@Query("SELECT d FROM Department d WHERE d.id = :deptId")
	Optional<Department> findByDeptCode(Long deptId);

}
