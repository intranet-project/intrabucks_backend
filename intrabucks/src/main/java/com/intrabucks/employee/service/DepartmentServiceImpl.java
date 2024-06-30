package com.intrabucks.employee.service;

import org.springframework.stereotype.Service;

import com.intrabucks.employee.data.reactdto.Department_DepartmentDTO;
import com.intrabucks.employee.data.repository.DepartmentRepository;
import com.intrabucks.entity.Department;

/**
 * 부서(Department) ServiceImpl : CRUD
 * @author 구은재
 * @version 1.0 
 * 2024-06-30
 **/

@Service
public class DepartmentServiceImpl implements DepartmentService{

	public final DepartmentRepository departmentRepository;
	
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}
	
	/**부서정보등록*/
	@Override
	public Long createDepartment(Department_DepartmentDTO departmentDTO) {
		
		Department department = new Department(); 
		department.setDeptCode(departmentDTO.getDeptCode());
		department.setDeptName(departmentDTO.getDeptName());	
		
		departmentRepository.save(department);
		
		return department.getDeptId();
	}

	/**부서정보수정*/
	@Override
	public Long updateDepartment(Department_DepartmentDTO departmentDTO) {
		Department department = departmentRepository.findByDeptCode(departmentDTO.getDeptId())
				.orElseThrow(()-> new IllegalArgumentException("Invalid Department ID:" + departmentDTO.getDeptId()));
		
		department.setDeptCode(departmentDTO.getDeptCode());
		department.setDeptName(departmentDTO.getDeptName());
		
		departmentRepository.save(department);
		
		return department.getDeptId();
	}
}
