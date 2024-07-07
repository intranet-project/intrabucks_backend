package com.intrabucks.approval.data.dto.reactdto;

import java.util.Date;

import com.intrabucks.entity.DocumentType;
import com.intrabucks.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApprovalDocument_ApprovlaDocumentDTO {
	private Long documentId;	// 문서 ID
	   
    private String title;	// 제목
    
    private String content;	// 문서내용_ 수정
    
    private String approvalStage;	// 문서상태
    
    private DocumentType documentType;	// 문서양식ID
    
    private Date createdAt;	// 작성일자
    
    private Date updatedAt;	// 수정일자
    
    private Employee employee;	// 직원ID
    
    private String departmentName;	 // 부서명
    
    private String approvalPathString;	// 결재경로문자열

}


