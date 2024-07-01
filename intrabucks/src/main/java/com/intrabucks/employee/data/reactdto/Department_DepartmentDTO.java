package com.intrabucks.employee.data.reactdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 부서(Department)의 DTO
 * @author 구은재
 * @version 1.0 
 * 2024-06-30
**/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department_DepartmentDTO {

	private Long deptId; // 부서ID
    private String deptCode; // 부서 코드
    private String deptName; // 부서명
	
}
