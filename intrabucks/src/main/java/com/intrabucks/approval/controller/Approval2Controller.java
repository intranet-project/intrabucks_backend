package com.intrabucks.approval.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intrabucks.approval.data.dto.reactdto.Approval_ApprovalDto;
import com.intrabucks.approval.service.Approval2Service;

@RestController
@RequestMapping(value = "/api/v1/intrabucks/approval")
public class Approval2Controller {
	
	@Autowired
	private Approval2Service approval2Service;
	
	public Approval2Controller(Approval2Service approval2Service) {
		this.approval2Service = approval2Service;
	}
	
	@GetMapping("/selectUser/{appDocId}")
	public ResponseEntity<ArrayList<Approval_ApprovalDto>> selectApprovalUserList(@PathVariable Long appDocId) {
		ArrayList<Approval_ApprovalDto> approvalList = approval2Service.selectApprovalList(appDocId);
		return ResponseEntity.ok(approvalList);
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<Approval_ApprovalDto> updateApprovalUserList(@RequestBody Approval_ApprovalDto approval_ApprovalDto) {
		Approval_ApprovalDto approval = approval2Service.updateApproval(approval_ApprovalDto);
		
		return ResponseEntity.ok().body(approval);
	}
}
