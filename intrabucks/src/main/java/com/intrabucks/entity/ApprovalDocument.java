package com.intrabucks.entity;
import java.sql.Clob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 전자결재 테이블(ApprovalDocument) 엔티티로, 결재 문서 테이블에 대한 내용을 담고 있음
 * @author 구은재
 * @version 1.0
 * 2024-06-27
 * **/
@Entity
@Table(name = "ApprovalDocument")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApprovalDocument {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "approval_document_seq")
    @SequenceGenerator(name = "approval_document_seq", sequenceName = "approval_document_seq", allocationSize = 1)
    @Column(name = "document_id")
    private Long documentId;	// 문서 ID
    
	@Column(name = "title")
    private String title;	// 제목
    
	//수정
	@Lob
	@Column(name = "content")
	private String content; 
    
	@Column(name = "approval_stage")
    private String approvalStage;	// 문서상태
    
	@ManyToOne
    @JoinColumn(name = "document_type_id", referencedColumnName = "document_type_id")
    private DocumentType documentType;	// 문서양식ID
    
	@Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;	// 작성일자
    
	@Column(name = "updated_at")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;	// 수정일자
    
	@ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    private Employee employee;	// 직원ID
    
	@Column(name = "department_name")
    private String departmentName;	 // 부서명
    
	@Column(name = "approval_path_string")
    private String approvalPathString;	// 결재경로문자열
}