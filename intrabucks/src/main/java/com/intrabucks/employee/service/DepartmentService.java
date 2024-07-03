package com.intrabucks.employee.service;

import com.intrabucks.employee.data.reactdto.Department_DepartmentDTO;
import com.intrabucks.employee.data.reactdto.Employee_EmployeeDTO;

/**
 * 부서(Department)의 Service : CRUD
 * @author 구은재
 * @version 1.0 
 * 2024-06-30
 **/

public interface DepartmentService {
	public Long createDepartment(Department_DepartmentDTO departmentDTO);	// 부서등록
	public Long updateDepartment(Department_DepartmentDTO departmentDTO);	// 부서정보수정
	public Department_DepartmentDTO selectOneDepartment(Long deptId);// 직원ID정보조회
}
