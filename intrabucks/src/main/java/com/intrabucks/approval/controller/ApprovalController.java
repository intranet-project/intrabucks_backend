package com.intrabucks.approval.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.intrabucks.approval.data.dto.reactdto.ApprovalDocument_ApprovalDocumentDTO;
import com.intrabucks.approval.data.dto.reactdto.Approval_ApprovalDto;
import com.intrabucks.approval.data.dto.reactdto.AttachedFile_AttachedFileDTO;
import com.intrabucks.approval.data.dto.reactdto.DocumentType_DocumentTypeDTO;
import com.intrabucks.approval.service.Approval2Service;
import com.intrabucks.approval.service.ApprovalService;
import com.intrabucks.entity.Approval;
import com.intrabucks.entity.ApprovalDocument;
import com.intrabucks.entity.DocumentType;
import com.intrabucks.jwt.JwtService;

/**
 * 전자결재 기능 관련 Controller로, 문서 리스트, 문서 선택 등의 기능 구현
 * 
 * @author 김아현
 * @version 1.0 2024-06-28
 **/

@RestController
@RequestMapping(value = "/api/v1/intrabucks/approval")
public class ApprovalController {
	@Autowired
	private ApprovalService approvalService;
	@Autowired
	private Approval2Service approval2Service; //wch
	@Autowired
	private JwtService jwtService;
	
	// FORM lIST 띄우기
	@GetMapping("/selectFormList")
	public ResponseEntity<List<DocumentType>> selectFormList() {
		List<DocumentType> documentTypeList = approvalService.selectFormList();
		return ResponseEntity.ok(documentTypeList);
	}

	// FORM 하나 선택 _ 폼 띄우기
	@GetMapping("/selectOneForm/{documentTypeId}")
	public ResponseEntity<DocumentType_DocumentTypeDTO> selectOneForm(@PathVariable Long documentTypeId) {
		DocumentType_DocumentTypeDTO selectDocument = approvalService.selectOneForm(documentTypeId);
		return ResponseEntity.ok(selectDocument);
	}

	// 파일 업로드
	@PostMapping("/uploadFile/{approvalID}")
	public ResponseEntity<AttachedFile_AttachedFileDTO> uploadFiles(@RequestBody MultipartFile file, @PathVariable Long approvalID) {
		System.err.println("");
		AttachedFile_AttachedFileDTO uploadFile = approvalService.uploadFiles(approvalID, file);
		return ResponseEntity.ok(uploadFile);
	}
	
	//파일 업로드 취소
	@DeleteMapping("deleteFile/{approvalID}")
	public ResponseEntity<String> deleteFile(@PathVariable Long approvalID){
		String deleteFile = approvalService.deleteFile(approvalID);
		return ResponseEntity.ok(deleteFile);
	}

	// 결재
	@PostMapping("/saveApproval")
	public ResponseEntity<ApprovalDocument_ApprovalDocumentDTO> saveApproval(
				@RequestBody ApprovalDocument_ApprovalDocumentDTO approvalDocumentDTO) {
			ApprovalDocument_ApprovalDocumentDTO approval = approvalService.saveApproval(approvalDocumentDTO);
			approval2Service.saveApprovalUser(approval); //wch
			return ResponseEntity.ok(approval);
		}
	
	//결재문서 리스트 확인 (기안 문서)
	@GetMapping("/selectApprovalList")
	public ResponseEntity<List<ApprovalDocument>> selectApprovalList(HttpServletRequest request){
        //아이디
		String id = jwtService.getAuthUser(request);
		List<ApprovalDocument> approvalDocumentList = approvalService.selectApprovalList(id);
		return ResponseEntity.ok(approvalDocumentList);
	}
	
	//결재문서 확인 (기안 문서)
	@GetMapping("/checkApproval/{approval_id}")
	public ResponseEntity<ApprovalDocument_ApprovalDocumentDTO> checkApproval(@PathVariable Long approval_id){
		ApprovalDocument_ApprovalDocumentDTO oneApproval = approvalService.checkApproval(approval_id);
		return ResponseEntity.ok(oneApproval);
	}
	
	//결재문서 리스트 확인 (받은 결재함)
	@GetMapping("/selectReadApprovalList")
	public ResponseEntity<List<Approval>> selectReadApprovalList(HttpServletRequest request){
        //아이디
		String id = jwtService.getAuthUser(request);
		List<Approval> approvalList = approvalService.selectReadApprovalList(id);
		return ResponseEntity.ok(approvalList);
	}
	
	//결재문서 리스트 확인 (받은 결재함)
		@GetMapping("/selectReadApprovalOne/{id}")
		public ResponseEntity<Approval_ApprovalDto> selectReadApprovalOne(Long id){
			Approval_ApprovalDto approval= approvalService.selectReadApprovalOne(id);
			return ResponseEntity.ok(approval);
		}
	

}
