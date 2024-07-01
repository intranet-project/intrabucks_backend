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

/**
 * 직원(Employee) ServiceImpl : CRUD
 * @author 구은재
 * @version 1.0 
 * 2024-06-30
 **/

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
		String deptCode = employeeDTO.getDeptCode(); // 수정된 부분: deptCode 추출
        Department department = departmentRepository.findByDeptCode(deptCode)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Department Code: " + deptCode));
		 
		Employee employee = new Employee();
        employee.setEmpName(employeeDTO.getEmpName());
        employee.setEmpPassword(employeeDTO.getEmpPassword());
        employee.setEmpEmail(employeeDTO.getEmpEmail());
        employee.setEmpPhone(employeeDTO.getEmpPhone());
        employee.setEmpAddress(employeeDTO.getEmpAddress());
        employee.setEmpJoinDate((Date)employeeDTO.getEmpJoinDate());
        employee.setEmpPosition(employeeDTO.getEmpPosition());
        employee.setDepartment(department);
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
                employee.getDepartment().getDeptCode(),
                employee.getWorkState()
            )
    	);
    }
	
	/**직원ID조회*/
	@Override
	public Employee_EmployeeDTO selectOneEmployee(Long empId) {
		// 직원 ID로 직원 정보를 조회합니다.
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Employee ID: " + empId));
       
        return new Employee_EmployeeDTO(
        		employee.getEmpId(),
        		employee.getEmpName(),
        		employee.getEmpPassword(),
                employee.getEmpEmail(), 
                employee.getEmpPhone(),
                employee.getEmpAddress(),
                (Date) employee.getEmpJoinDate(),
                employee.getEmpPosition(),
                employee.getDepartment().getDeptCode(),
                employee.getWorkState());
	}
    
	/**직원정보수정*/
	@Override
	public Long updateEmployee(Employee_EmployeeDTO employeeDTO) {
		Employee employee = employeeRepository.findById(employeeDTO.getEmpId())
				.orElseThrow(()-> new IllegalArgumentException("Invalid Employee ID:" + employeeDTO.getEmpId()));
		
		String deptCode = employeeDTO.getDeptCode(); // 수정된 부분: deptCode 추출
        Department department = departmentRepository.findByDeptCode(deptCode)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Department Code: " + deptCode));
		
        employee.setEmpName(employeeDTO.getEmpName());
        employee.setEmpPassword(employeeDTO.getEmpPassword());
        employee.setEmpEmail(employeeDTO.getEmpEmail());
        employee.setEmpPhone(employeeDTO.getEmpPhone());
        employee.setEmpAddress(employeeDTO.getEmpAddress());
        employee.setEmpJoinDate((Date)employeeDTO.getEmpJoinDate());
        employee.setEmpPosition(employeeDTO.getEmpPosition());
        employee.setDepartment(department);
        employee.setWorkState(employeeDTO.getWorkState());

        employeeRepository.save(employee);

        return employee.getEmpId();
	}

	/**직원정보삭제*/
	@Override
	public Long deleteEmpoyee(Long empId) {
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Employee ID: " + empId));
       
        employeeRepository.delete(employee);

        return employee.getEmpId();
	}
}
