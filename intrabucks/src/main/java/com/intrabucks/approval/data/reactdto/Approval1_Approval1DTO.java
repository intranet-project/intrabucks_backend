package com.intrabucks.approval.data.reactdto;

import com.intrabucks.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 결재라인 DTO:  기안자 및 결재자1, 2, 3
 * @author 구은재
 * @version 1.0 
 * 2024-06-30
**/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Approval1_Approval1DTO {

	private Employee  empId1; //결재자 직원Id
    private String approvalState1;//결재 or 기안
    
    private Employee empId2; //결재자 직원Id
    private String approvalState2;	//결재 or 기안
    
    private Employee empId3; //결재자 직원Id
    private String approvalState3;	//결재 or 기안
    
    private Employee empId4; //결재자 직원Id
    private String approvalState4;	//결재 or 기안
    
}
