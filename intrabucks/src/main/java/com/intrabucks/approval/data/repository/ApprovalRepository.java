package com.intrabucks.approval.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intrabucks.entity.Approval;
import com.intrabucks.entity.Employee;
import com.intrabucks.entity.Employee;

public interface ApprovalRepository extends JpaRepository<Approval, Long> {
	List<Approval> findByDocumentAppDocId(Long appDocId);

	 List<Approval> findAllByEmployee(Employee employee);
}
