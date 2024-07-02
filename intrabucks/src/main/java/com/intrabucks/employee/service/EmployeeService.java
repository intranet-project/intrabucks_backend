package com.intrabucks.employee.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.intrabucks.employee.data.reactdto.Employee_EmployeeDTO;

/**
 * 직원(Employee)의 Service :  deleteEmployeeAndMoveToQuitter 추가
 * @author 구은재
 * @version 1.0 
 * 2024-06-30
 **/

public interface EmployeeService {
	Page<Employee_EmployeeDTO> ListEmployee(String empName, Pageable pageable); //직원전체정보조회
	public Employee_EmployeeDTO selectOneEmployee(Long empId);	// 직원ID정보조회
	public Long createEmployee(Employee_EmployeeDTO EmployeeDTO);	// 직원정보등록
	public Long updateEmployee(Employee_EmployeeDTO EmployeeDTO);	// 직원정보수정
	boolean deleteEmployeeAndMoveToQuitter(Long empId);  // 직원 정보를 퇴사자로 옮긴 후 삭제

}
