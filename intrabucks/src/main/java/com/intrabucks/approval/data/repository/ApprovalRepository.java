package com.intrabucks.approval.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intrabucks.entity.Approval;

public interface ApprovalRepository extends JpaRepository<Approval, Long> {

}
