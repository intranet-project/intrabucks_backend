package com.intrabucks.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 전자결재 테이블(Approval) 엔티티로, 결재 테이블에 대한 내용을 담고 있음
 * @author 구은재
 * @version 1.0
 * 2024-06-27
 * **/
@Entity
@Table(name = "Approval")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Approval {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "approval_seq")
    @SequenceGenerator(name = "approval_seq", sequenceName = "approval_seq", allocationSize = 1)
    @Column(name = "approval_id")
    private Long approvalId;	//결재번호
	
    @ManyToOne
    @JoinColumn(name = "approval_doc_id", nullable = false)
    private ApprovalDocument document;	//문서ID
    
    @Column(name = "approval_step")
    private Long approvalStep;	// 결재단계
    
    @Column(name = "approval_type")
    private String approvalType;	// 결재종류
    
    @Column(name = "approval_result")
    private String approvalResult;	// 결재결과
    
    @Column(name = "approval_comment")
    private String approvalComment;	// 코멘트
    
    @Column(name = "approval_date")
    @Temporal(TemporalType.DATE)
    private Date approvalDate;	// 결재일자
    
    @Column(name = "approval_position")
    private String approvalPosition;		// 직위
    
    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    private Employee employee;	//직원ID
}