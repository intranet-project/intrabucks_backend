package com.intrabucks.approval.service;

import com.intrabucks.approval.data.reactdto.Approval1_Approval1DTO;
import com.intrabucks.employee.data.reactdto.Employee_EmployeeDTO;
import com.intrabucks.employee.data.repository.EmployeeRepository;
import com.intrabucks.entity.Employee;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 결재라인 Approval1ServiceImpl :  결재라인 생성
 * @author 구은재
 * @version 1.0 
 * 2024-07-06
**/


@Service
public class Approval1ServiceImp implements Approval1Service {
	
	//추가
	@Autowired
	private  EmployeeRepository employeeRepository;

	@Override
	public String createApproval1(Approval1_Approval1DTO approval1DTO) {
	  StringBuilder approvalLineBuilder = new StringBuilder();
	  
	  for (Approval1_Approval1DTO.ApprovalStepDTO approvalStep : approval1DTO.getApprovalSteps()) {
          if(approvalStep.getEmployee() != null) {
        	  Employee employee = approvalStep.getEmployee();
              String empId = employee.getEmpId().toString();
              String empName = employee.getEmpName();
              String deptId =  approvalStep.getDeptCode() ;
              String approvalState = approvalStep.getApprovalState();

              approvalLineBuilder.append(empId).append(",").append(empName).append(",").append(deptId).append(",").append(approvalState).append("//-//");
          } else {
        	  String empId = approvalStep.getEmpId().toString();
              String empName = approvalStep.getEmpName();
              String deptId =  approvalStep.getDeptCode() ;
              String approvalState = approvalStep.getApprovalState();

              approvalLineBuilder.append(empId).append(",").append(empName).append(",").append(deptId).append(",").append(approvalState).append("//-//");
          }
		  
      }

      String approvalLine = approvalLineBuilder.toString();
      System.out.println("생성된 결재 라인: " + approvalLine); // 콘솔에 출력

      return approvalLine;
  }

	@Override
	public Employee_EmployeeDTO sessionEmployee(String empEmail) {
		System.err.println("Attempting to find employee with email: " + empEmail);
		
		//emp id로 사람 조회하기
		Employee employee = employeeRepository.findByEmpEmail(empEmail);
		
		Employee_EmployeeDTO employeeDTO = new Employee_EmployeeDTO();
		if (employee != null) {
		
			//dto 객체로 변환
			employeeDTO.setDeptCode(employee.getDepartment().getDeptCode());
			employeeDTO.setEmpEmail(employee.getEmpEmail());
			employeeDTO.setEmpName(employee.getEmpName());
			employeeDTO.setEmpPosition(employee.getEmpPosition());
			employeeDTO.setEmpId(employee.getEmpId());
			//나머지 다 채우기
		}
		
		 System.out.println("Returning employee DTO: " + employeeDTO);
		
		return employeeDTO;
	}

	
	    
}
