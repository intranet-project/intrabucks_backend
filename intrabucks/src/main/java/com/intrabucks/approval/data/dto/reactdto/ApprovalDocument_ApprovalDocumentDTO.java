package com.intrabucks.approval.data.dto.reactdto;

import java.util.Date;

import com.intrabucks.entity.DocumentType;
import com.intrabucks.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 설명: ApprovalDocument DB에 사용자 입력값 작성
 * @author 김아현
 * @version 3.0 
 * 2024-07-08
**/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApprovalDocument_ApprovalDocumentDTO {
	private Long appDocId; // 문서 ID
	private DocumentType docTypeId; // 문서양식 ID
	private String appDocTitle; // 제목
	private String appDocDepartment; // 기안부서
	private Employee empId; // 기안자
	private String appDocDepartmentGrade; // 비밀 등급
	private String appDocContent; // 문서 내용
	private String appDocStage; // 문서 상태
	private Date appDocCreatedAt; // 작성일자
	private Date appDocUpdatedAt; // 수정일자
	private String appDocPathString; // 결재경로 문자열

}





