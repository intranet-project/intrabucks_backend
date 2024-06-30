package com.intrabucks.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intrabucks.employee.data.reactdto.Department_DepartmentDTO;
import com.intrabucks.employee.service.DepartmentService;

/**
 * 부서(Department) Controller : CU 부서등록, 부서정보정수 (Talend완료)
 * @author 구은재
 * @version 1.0
 * 2024-06-30
 * **/

@RestController
@RequestMapping("api/department")
public class DepartmentController {

	private final DepartmentService departmentService;
	
	@Autowired
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	/**부서등록*/
	@PostMapping("/create")
	public ResponseEntity<Long> createDepartment(@RequestBody Department_DepartmentDTO departmentDTO) {
		Long DeptId = departmentService.createDepartment(departmentDTO);
		// return new ResponseEntity<>(empId, HttpStatus.CREATED);
		return ResponseEntity.ok().body(DeptId);
	}
	
	/**부서정보수정*/
	@PutMapping("/update/{DeptId}")
	public ResponseEntity<Long> updateDepartment(@RequestBody Department_DepartmentDTO departmentDTO) {
		Long DeptId = departmentService.updateDepartment(departmentDTO);
		// return new ResponseEntity<>(empId, HttpStatus.update);
		return ResponseEntity.ok().body(DeptId);
	}
}
