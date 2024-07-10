package com.intrabucks.approval.service;

import org.springframework.stereotype.Service;

import com.intrabucks.approval.data.dto.reactdto.ApprovalDocument_ApprovalDocumentDTO;
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
			}
			System.out.println(arr[3]+" : "+approval);
			approvalRepository.save(approval);
		}
	}

}