package com.intrabucks.approval.service;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intrabucks.approval.data.dto.reactdto.DocumentType_DocumentTypeDTO;
import com.intrabucks.approval.data.repository.ApprovalRepository;
import com.intrabucks.approval.data.repository.DocumentTypeRepository;
import com.intrabucks.entity.DocumentType;

@Service
public class ApprovalServiceImpl implements ApprovalService{
	
	@Autowired
    private	ApprovalRepository approvalRepository;
	
	@Autowired
	private DocumentTypeRepository documentTypeRepository;

	//폼 리스트 뽑기
	@Override
	public List<DocumentType> selectFormList() {
		List<DocumentType> FormList = documentTypeRepository.findAll();
		return FormList;
	}

	//폼 상세보기(폼 띄우기)
	@Override
	public DocumentType_DocumentTypeDTO selectOneForm(Long documentTypeId) {
		DocumentType oneForm = documentTypeRepository.getById(documentTypeId);
		
		//폼 띄우기 FormName= 품의서 #1.html
		if (oneForm != null) {
			String FormName = oneForm.getDocumentFormName();
			if (FormName != null){
				
				//file 복사본 생성
				File file = new File("/src/main/resources/data/" + FormName);
				
				String line = "";
				StringBuilder sb = new StringBuilder();
				/**
				 * while ((s = br)) {
					type type = (type) en.nextElement();
					
				}
				*/
						
			}
			
		}
		return null;
	}

}
