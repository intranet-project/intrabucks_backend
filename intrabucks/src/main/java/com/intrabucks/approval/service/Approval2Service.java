package com.intrabucks.approval.service;

import java.util.ArrayList;

import com.intrabucks.approval.data.dto.reactdto.ApprovalDocument_ApprovalDocumentDTO;
import com.intrabucks.approval.data.dto.reactdto.Approval_ApprovalDto;

public interface Approval2Service {
	void saveApprovalUser(ApprovalDocument_ApprovalDocumentDTO approvalDocumentDTO);
	ArrayList<Approval_ApprovalDto> selectApprovalList(Long appDocId);
	Approval_ApprovalDto updateApproval(Approval_ApprovalDto approval_ApprovalDto);
}