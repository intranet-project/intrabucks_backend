package com.intrabucks.approval.service;

import com.intrabucks.approval.data.reactdto.Approval1_Approval1DTO;
import com.intrabucks.employee.data.reactdto.Employee_EmployeeDTO;


/**
 * 결재라인 Approval1Service :  결재라인 생성
 * @author 구은재
 * @version 2.0 
 * 2024-07-06
**/

public interface Approval1Service {

	String  createApproval1(Approval1_Approval1DTO approval1DTO);
	
	//session 정보로 employee 한명 조회하기
	Employee_EmployeeDTO sessionEmployee(String empEmail);

}
