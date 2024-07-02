package com.intrabucks.employee.data.reactdto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 직원(Employee) DTO
 * @author 구은재
 * @version 1.0 
 * 2024-06-30
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee_EmployeeDTO {

	private Long empId; // 사원 ID
    private String empName; // 이름
    private String empPassword; // 비밀번호
    private String empEmail; // 이메일
    private String empPhone; // 핸드폰 번호
    private String empAddress; // 주소
    private Date empJoinDate; // 입사일
    private String empPosition; // 직책
    private String deptCode; // 부서 코드
    private String workState; // 재직 상태 (Y/N)
}
