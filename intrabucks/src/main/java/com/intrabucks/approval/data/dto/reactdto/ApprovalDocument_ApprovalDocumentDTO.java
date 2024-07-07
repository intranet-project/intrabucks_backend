package com.intrabucks.approval.data.dto.reactdto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 문서(ApprovalDocument) DTO 생성
 * @author 구은재
 * @version 2.0 
 * 2024-07-07
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApprovalDocument_ApprovalDocumentDTO {

	private Long documentId; // 문서 ID
    private String title; // 제목
    private String content; // 문서 내용
    private String approvalStage; // 문서 상태
    private Long documentTypeId; // 문서 양식 DTO
    private Date createdAt; // 작성 일자
    private Date updatedAt; // 수정 일자
    private Long empId; // 직원 DTO
    private String departmentName; // 부서명
    private String approvalPathString; // 결재 경로 문자열
}
