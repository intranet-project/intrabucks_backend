package com.intrabucks.approval.service;

import com.intrabucks.approval.data.reactdto.Approval1_Approval1DTO;

import org.springframework.stereotype.Service;
/**
 * 결재라인 Approval1ServiceImpl :  결재라인 생성
 * @author 구은재
 * @version 1.0 
 * 2024-06-30
**/


@Service
public class Approval1ServiceImp implements Approval1Service {

//    private final Approval1Repository approval1Repository;
//
//    @Autowired
//    public Approval1ServiceImp(Approval1Repository approval1Repository) {
//        this.approval1Repository = approval1Repository;
//    }

    @Override
    public String createApproval1(Approval1_Approval1DTO approval1DTO) {
        StringBuilder approvalLineBuilder = new StringBuilder();

        // 기안자 정보 처리
        if (approval1DTO.getEmpId1().getEmpId()!= null) {
            String empId1 = approval1DTO.getEmpId1().getEmpId().toString();
            String empName1 = approval1DTO.getEmpId1().getEmpName();
            String deptId1 = approval1DTO.getEmpId1().getDepartment().getDeptId().toString();
            String approvalState1 = approval1DTO.getApprovalState1();

            // 결재 문자열 추가
            approvalLineBuilder.append(empId1).append(",").append(empName1).append(",").append(deptId1).append(",").append(approvalState1).append("//-//");
        } else {
            System.out.println("기안자 정보가 없어서 오류 발생");
        }

        // 결재자1 정보 처리
        if (approval1DTO.getEmpId2().getEmpId()!= null) {
            String empId2 = approval1DTO.getEmpId2().getEmpId().toString();
            String empName2 = approval1DTO.getEmpId2().getEmpName();
            String deptId2 = approval1DTO.getEmpId2().getDepartment().getDeptId().toString();
            String approvalState2 = approval1DTO.getApprovalState2();

            // 결재 문자열 추가
            approvalLineBuilder.append(empId2).append(",").append(empName2).append(",").append(deptId2).append(",").append(approvalState2).append("//-//");
        }

        // 결재자2 정보 처리
        if (approval1DTO.getEmpId3().getEmpId()!= null) {
            String empId3 = approval1DTO.getEmpId3().getEmpId().toString();
            String empName3 = approval1DTO.getEmpId3().getEmpName();
            String deptId3 = approval1DTO.getEmpId3().getDepartment().getDeptId().toString();
            String approvalState3 = approval1DTO.getApprovalState3();

            // 결재 문자열 추가
            approvalLineBuilder.append(empId3).append(",").append(empName3).append(",").append(deptId3).append(",").append(approvalState3).append("//-//");
        }

        // 결재자3 정보 처리
        if (approval1DTO.getEmpId4().getEmpId()!= null) {
            String empId4 = approval1DTO.getEmpId4().getEmpId().toString();
            String empName4 = approval1DTO.getEmpId4().getEmpName();
            String deptId4 = approval1DTO.getEmpId4().getDepartment().getDeptId().toString();
            String approvalState4 = approval1DTO.getApprovalState4();

            // 결재 문자열 추가
            approvalLineBuilder.append(empId4).append(",").append(empName4).append(",").append(deptId4).append(",").append(approvalState4);
        }

        // 최종 결재 문자열 반환
        return approvalLineBuilder.toString();
    }
}
