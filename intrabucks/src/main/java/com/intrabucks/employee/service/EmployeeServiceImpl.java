package com.intrabucks.employee.service;

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.intrabucks.employee.data.reactdto.Employee_EmployeeDTO;
import com.intrabucks.employee.data.repository.DepartmentRepository;
import com.intrabucks.employee.data.repository.EmployeeRepository;
import com.intrabucks.entity.Department;
import com.intrabucks.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	public final EmployeeRepository employeeRepository;
	public final DepartmentRepository departmentRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
		
	}

	/**직원신규등록*/
	@Override
	public Long createEmployee(Employee_EmployeeDTO employeeDTO) {
		// Department department = DepartmentRepository.findById(employeeDTO.getDeptCode())
		//	        .orElseThrow(() -> new IllegalArgumentException("Invalid Department Code: " + employeeDTO.getDeptCode()));
		 
		Employee employee = new Employee();
		//DTO로 받아서 엔티티에 추가해서 DB 저장
        employee.setEmpName(employeeDTO.getEmpName());
        employee.setEmpPassword(employeeDTO.getEmpPassword());
        employee.setEmpEmail(employeeDTO.getEmpEmail());
        employee.setEmpPhone(employeeDTO.getEmpPhone());
        employee.setEmpAddress(employeeDTO.getEmpAddress());
        employee.setEmpJoinDate(employeeDTO.getEmpJoinDate());
        employee.setEmpPosition(employeeDTO.getEmpPosition());
      //employee.setDepartment(department);
        employee.setWorkState(employeeDTO.getWorkState());

        employeeRepository.save(employee);
        
        return employee.getEmpId();
	}
	
	/**직원전체조회*/
	@Override
	public Page<Employee_EmployeeDTO> ListEmployee(String empName, Pageable pageable) {

		int page = pageable.getPageNumber();
	    if (page < 0) {
	        page = 0;
	    }
		
		final int pageSize = 10;
    	
		pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.DESC, "empJoinDate"));
    	
    	Page<Employee> employeePage;
    	
    	if (empName == null || empName.isEmpty()) {
            // empName이 null이거나 빈 문자열인 경우 모든 직원을 조회
            employeePage = employeeRepository.findAll(pageable);
        } else {
            // empName이 주어진 경우 해당 이름을 포함하는 직원을 조회
            employeePage = employeeRepository.findByEmpNameContainingIgnoreCase(empName, pageable);
        }   
    	
    	return employeePage.map(employee ->
    	new Employee_EmployeeDTO(
    			employee.getEmpId(), 
    			employee.getEmpName(), 
    			employee.getEmpPassword(),
                employee.getEmpEmail(), 
                employee.getEmpPhone(), 
                employee.getEmpAddress(), 
                (Date) employee.getEmpJoinDate(),
                employee.getEmpPosition(),  
                employee.getWorkState()
            )
    	);
    	//employee.getDepartment().getDeptCode(),
    }
	
	/**직원ID조회*/
	@Override
	public Employee_EmployeeDTO selectOneEmployee(Long empId) {
		// 직원 ID로 직원 정보를 조회합니다.
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Employee ID: " + empId));
       
        return new Employee_EmployeeDTO(employee.getEmpId(), employee.getEmpName(), employee.getEmpPassword(),
                employee.getEmpEmail(), employee.getEmpPhone(), employee.getEmpAddress(), (Date) employee.getEmpJoinDate(),
                employee.getEmpPosition(),  employee.getWorkState());
	}
	
    
	/**직원정보수정*/
	@Override
	public Long updatedEmpolyee(Employee_EmployeeDTO employeeDTO) {
		Employee employee = employeeRepository.findById(employeeDTO.getEmpId())
				.orElseThrow(()-> new IllegalArgumentException("Invalid Employee ID:" + employeeDTO.getEmpId()));
		
		//Department department = DepartmentRepository.findById(employeeDTO.getDeptCode())
		//        .orElseThrow(() -> new IllegalArgumentException("Invalid Department Code: " + employeeDTO.getDeptCode()));
		
		 // 직원 정보 업데이트
        employee.setEmpName(employeeDTO.getEmpName());
        employee.setEmpPassword(employeeDTO.getEmpPassword());
        employee.setEmpEmail(employeeDTO.getEmpEmail());
        employee.setEmpPhone(employeeDTO.getEmpPhone());
        employee.setEmpAddress(employeeDTO.getEmpAddress());
        employee.setEmpJoinDate(employeeDTO.getEmpJoinDate());
        employee.setEmpPosition(employeeDTO.getEmpPosition());
        //employee.setDepartment(department);
        employee.setWorkState(employeeDTO.getWorkState());

        // 직원 정보 저장
        employeeRepository.save(employee);

        return employee.getEmpId();
	}

	/**직원정보삭제*/
	@Override
	public Long deleteEmpoyee(Long empId) {
		// 직원 ID로 직원 정보를 조회합니다.
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Employee ID: " + empId));
       
        // 직원 정보를 삭제합니다.
        employeeRepository.delete(employee);

        // 삭제된 직원의 ID를 반환합니다.
        return employee.getEmpId();
	}



}
