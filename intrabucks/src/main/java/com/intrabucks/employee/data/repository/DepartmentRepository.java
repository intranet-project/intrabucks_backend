package com.intrabucks.employee.data.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intrabucks.entity.Department;


public interface DepartmentRepository extends JpaRepository<Department, Long> {

	static Optional<Department> findById(String deptCode) {
		// TODO Auto-generated method stub
		return null;
	}





	

}
