package com.intrabucks.employee.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intrabucks.employee.data.reactdto.Department_DepartmentDTO;
import com.intrabucks.employee.data.reactdto.Employee_EmployeeDTO;
import com.intrabucks.employee.data.repository.DepartmentRepository;
import com.intrabucks.employee.data.repository.EmployeeRepository;
import com.intrabucks.employee.service.DepartmentService;
import com.intrabucks.entity.Department;

/**
 * 부서(Department) Controller : CU 부서등록, 부서정보정수 (Talend완료)
 * @author 구은재
 * @version 1.0
 * 2024-06-30
 * **/

@RestController
@RequestMapping("/api/v1/intrabucks/department")
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
	
	/**부서ID조회*/
	@GetMapping("/{deptId}")
	public ResponseEntity<Department_DepartmentDTO> selectOneDepartment(@PathVariable Long deptId) {
		Department_DepartmentDTO departmentDTO = departmentService.selectOneDepartment(deptId);

		if (departmentDTO != null) {
			return ResponseEntity.ok().body(departmentDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	
	}

}
