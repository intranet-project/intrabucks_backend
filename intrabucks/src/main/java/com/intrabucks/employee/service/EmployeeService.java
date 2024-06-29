package com.intrabucks.employee.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.intrabucks.employee.data.reactdto.Employee_EmployeeDTO;

public interface EmployeeService {

	//public List<Employee_EmployeeDTO> ListEmployee(String empName, Integer page); //직원전체정보조회
	Page<Employee_EmployeeDTO> ListEmployee(String empName, Pageable pageable);
	public Employee_EmployeeDTO selectOneEmployee(Long empId);	// 직원ID정보조회
	public Long createEmployee(Employee_EmployeeDTO EmployeeDTO);	// 직원정보등록
	public Long updatedEmpolyee(Employee_EmployeeDTO EmployeeDTO);	// 직원정보수정
	public Long deleteEmpoyee(Long empId);	// 직원정보삭제
	
	
}
