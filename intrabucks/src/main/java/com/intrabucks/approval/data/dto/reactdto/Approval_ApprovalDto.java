package com.intrabucks.approval.data.dto.reactdto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Approval_ApprovalDto {
	
	private Long approvalId; //결재ID
	private Long appDocId;	//문서ID
    private Long approvalStep;	// 결재단계
    private String approvalType;	// 결재종류
    private String approvalResult;	// 결재결과
    private String approvalComment;	// 코멘트
    private Date approvalDate;	// 결재일자
    private String approvalPosition; // 직위
    private Long empId;	//직원ID
}
