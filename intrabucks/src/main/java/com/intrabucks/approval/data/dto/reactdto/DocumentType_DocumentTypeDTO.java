package com.intrabucks.approval.data.dto.reactdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 결재문서함(DocumentType) DTO : 어노테이션 추가
 * @author 구은재
 * @version 1.0 
 * 2024-07-07
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentType_DocumentTypeDTO {
	
		private Long documentTypeId; // 문서 양식 ID

	    private String documentTypeName; // 문서 양식 이름

	    private String documentTypeContent; // 문서 양식 내용
	 
	    private String documentAuthority; // 권한
	   
	    private String documentFormName; // 첨부 양식

}
