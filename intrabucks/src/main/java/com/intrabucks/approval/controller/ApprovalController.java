package com.intrabucks.approval.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.intrabucks.approval.data.dto.reactdto.DocumentType_DocumentTypeDTO;
import com.intrabucks.approval.service.ApprovalService;
import com.intrabucks.entity.DocumentType;

@RestController
public class ApprovalController {
	@Autowired
	private ApprovalService approvalService;

	// FORM lIST 띄우기
	public ResponseEntity<List<DocumentType>> selectFormList() {
		List<DocumentType> documentTypeList = approvalService.selectFormList();
		return ResponseEntity.ok(documentTypeList);
	}

	// FORM lIST 띄우기
	public ResponseEntity<DocumentType_DocumentTypeDTO> selectOneForm(@PathVariable Long documentTypeId) {
		DocumentType_DocumentTypeDTO selectDocument = approvalService.selectOneForm(documentTypeId);
		return ResponseEntity.ok(null);
	}

}
