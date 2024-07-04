package com.intrabucks.approval.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.intrabucks.approval.data.dto.reactdto.DocumentType_DocumentTypeDTO;
import com.intrabucks.entity.DocumentType;

public interface ApprovalService {

	//FORM lIST 띄우기
	List<DocumentType> selectFormList();
	
	//FORM 하나 상세보기 (폼 띄우기)
	DocumentType_DocumentTypeDTO selectOneForm(Long documentTypeId);
}
