package com.intrabucks.approval.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.intrabucks.approval.data.dto.reactdto.ApprovalDocument_ApprovalDocumentDTO;
import com.intrabucks.approval.data.dto.reactdto.Approval_ApprovalDto;
import com.intrabucks.approval.data.repository.ApprovalRepository;
import com.intrabucks.entity.Approval;
import com.intrabucks.entity.ApprovalDocument;
import com.intrabucks.entity.Employee;

@Service
public class Approval2ServiceImpl implements Approval2Service {

	private final ApprovalRepository approvalRepository;

	public Approval2ServiceImpl(ApprovalRepository approvalRepository) {
		this.approvalRepository = approvalRepository;
	}

	@Override
	public void saveApprovalUser(ApprovalDocument_ApprovalDocumentDTO approvalDocumentDTO) {

		String docsignpath = approvalDocumentDTO.getAppDocPathString();
		
		String[] users = docsignpath.split("//-//");
		
		for (int i = 0; i < users.length; i++) {
			if ("".equals(users[i])) continue;
			
			String[] arr = users[i].split(","); // 사번(doc_id), 이름, 직책, 기안/결재
			Approval approval = new Approval();
			ApprovalDocument document = new ApprovalDocument();
			Employee employee = new Employee();
			
			document.setAppDocId(approvalDocumentDTO.getAppDocId());
			employee.setEmpId(Long.parseLong(arr[0]));
			
			approval.setDocument(document);
			approval.setApprovalStep((long)i);
			approval.setApprovalPosition(arr[2]);
			approval.setApprovalType(arr[3]);
			
			approval.setEmployee(employee);
			if ("기안자".equals(arr[3])) {
				approval.setApprovalResult("승인");
				Date date = new Date();
				approval.setApprovalDate(date);
			}
			System.out.println(arr[3]+" : "+approval);
			approvalRepository.save(approval);
		}
	}

	@Override
	public ArrayList<Approval_ApprovalDto> selectApprovalList(Long appDocId) {
		List<Approval_ApprovalDto> approvalData = approvalRepository.findByDocumentAppDocId(appDocId).stream()
				.map(approval -> Approval_ApprovalDto.builder()
						.approvalId(approval.getApprovalId())
						.appDocId(approval.getDocument().getAppDocId())
						.approvalStep(approval.getApprovalStep())
						.approvalType(approval.getApprovalType())
						.approvalResult(approval.getApprovalResult())
						.approvalComment(approval.getApprovalComment())
						.approvalDate(approval.getApprovalDate())
						.approvalPosition(approval.getApprovalPosition())
						.empId(approval.getEmployee().getEmpId())
						.empName(approval.getEmployee().getEmpName()).build())
				.collect(Collectors.toList());
		return (ArrayList<Approval_ApprovalDto>)approvalData;
	}

	@Override
	public Approval_ApprovalDto updateApproval(Approval_ApprovalDto approval_ApprovalDto) {

			ApprovalDocument approvalDocument = new ApprovalDocument();
			Employee employee = new Employee();
			Approval approval = new Approval();
			
			approvalDocument.setAppDocId(approval_ApprovalDto.getAppDocId());
			employee.setEmpId(approval_ApprovalDto.getEmpId());
			Date currentTime = new Date();
			
			approval.setApprovalId(approval_ApprovalDto.getApprovalId());
			approval.setDocument(approvalDocument);
			approval.setApprovalStep(approval_ApprovalDto.getApprovalStep());
			approval.setApprovalType(approval_ApprovalDto.getApprovalType());
			approval.setApprovalResult(approval_ApprovalDto.getApprovalResult());
			approval.setApprovalComment(approval_ApprovalDto.getApprovalComment());
			approval.setApprovalDate(currentTime);
			approval.setApprovalPosition(approval_ApprovalDto.getApprovalPosition());
			approval.setEmployee(employee);
			
		approvalRepository.save(approval);
		
		return approval_ApprovalDto;
	}

}