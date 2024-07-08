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
public class ApprovalDocument{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "approval_document_seq")
    @SequenceGenerator(name = "approval_document_seq", sequenceName = "approval_document_seq", allocationSize = 1)
    @Column(name = "approval_doc_id")
    private Long appDocId; //문서 ID(전자결재)

    @ManyToOne
    @JoinColumn(name = "document_type_id", referencedColumnName = "document_type_id")
    private DocumentType documentType;  //HTML 폼 문서 매핑

    @Column(name = "app_doc_title")
    private String appDocTitle;  //문서 ID

    @Column(name = "app_doc_department")
    private String appDocDepartment;  //기안부서

    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    private Employee employee;  //기안자

    @Column(name = "app_doc_department_grade")
    private String appDocDepartmentGrade;  //비밀 등급

    @Column(name = "app_doc_content")
    private String appDocContent;  //결재 내용

    @Column(name = "app_doc_stage")
    private String appDocStage;  //문서 상태

    @Column(name = "app_doc_created_at")
    @Temporal(TemporalType.DATE)
    private Date appDocCreatedAt;  //작성일자

    @Column(name = "app_doc_updated_at")
    @Temporal(TemporalType.DATE)
    private Date appDocUpdatedAt;  //수정일자

    @Column(name = "app_doc_path_string")
    private String appDocPathString;  //결재경로 문자열
}
