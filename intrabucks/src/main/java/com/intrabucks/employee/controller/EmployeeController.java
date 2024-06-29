package com.intrabucks.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intrabucks.employee.data.reactdto.Employee_EmployeeDTO;
import com.intrabucks.employee.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private final EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// 직원신규등록
	@PostMapping("/create")
	public ResponseEntity<Long> createEmployee(@RequestBody Employee_EmployeeDTO employeeDTO) {
		Long empId = employeeService.createEmployee(employeeDTO);
		// return new ResponseEntity<>(empId, HttpStatus.CREATED);
		return ResponseEntity.ok().body(empId);
	}

	// 직원전체조회
	@GetMapping("/select")
	public ResponseEntity<Page<Employee_EmployeeDTO>> getAllEmployees(@RequestParam(required = false) String empName,
			@RequestParam(required = false) Integer page, @RequestParam(defaultValue = "10") int size) {

		int pageNumber = (page != null && page > 0) ? page - 1 : 0;
		PageRequest pageable = PageRequest.of(pageNumber, size, Sort.by(Sort.Direction.DESC, "empJoinDate"));
		Page<Employee_EmployeeDTO> employees = employeeService.ListEmployee(empName, pageable);
		return ResponseEntity.ok().body(employees);
	}

	// 직원ID조회
	@GetMapping("/{empId}")
	public ResponseEntity<Employee_EmployeeDTO> selectOneEmployee(@PathVariable Long empId) {
		Employee_EmployeeDTO employeeDTO = employeeService.selectOneEmployee(empId);

		if (employeeDTO != null) {
			return ResponseEntity.ok().body(employeeDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// 직원정보수정
	@PutMapping("/update")
	public ResponseEntity<Long> updateEmployee(@RequestBody Employee_EmployeeDTO employeeDTO) {
		Long empId = employeeService.createEmployee(employeeDTO);
		// return new ResponseEntity<>(empId, HttpStatus.update);
		return ResponseEntity.ok().body(empId);
	}

	// 직원정보삭제
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<Long> deleteEmployee(@PathVariable Long empId) {
		Long deletedempId = employeeService.deleteEmpoyee(empId);
		return ResponseEntity.ok().body(deletedempId);
	}

}
