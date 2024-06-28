package com.intrabucks.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 전자결재 테이블(AttachedFile) 엔티티로, 첨부파일 테이블에 대한 내용을 담고 있음
 * @author 구은재
 * @version 1.0
 * 2024-06-27
 * **/
@Entity
@Table(name = "AttachedFile")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachedFile {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attached_file_seq")
    @SequenceGenerator(name = "attached_file_seq", sequenceName = "attached_file_seq", allocationSize = 1)
    @Column(name = "file_id")
    private Long fileId;	//파일ID
    
	@Column(name = "file_name", length = 100)
    private String fileName;	//파일명
    
	@Column(name = "actual_file_name", length = 30)
    private String actualFileName;	//실제파일명
    
	@Column(name = "file_size")
    private Long fileSize;	//파일크기
    
	@ManyToOne
    @JoinColumn(name = "document_id", referencedColumnName = "document_id")
    private ApprovalDocument document;	//문서ID
}