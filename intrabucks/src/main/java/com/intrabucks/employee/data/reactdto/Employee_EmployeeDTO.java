package com.intrabucks.employee.data.reactdto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    //private String deptCode; // 부서 이름
    private String workState; // 재직 상태 (Y/N)
}
